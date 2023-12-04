import {
    ApiResponse,
    AuthApi,
    BaseError,
    BaseErrorType, BranchOfficeApi, CatalogApi,
    Configuration,
    ErrorContext,
    HTTPQuery,
    Middleware,
    ResponseContext, UsersApi,
} from 'api';

import {auth} from 'app/App';
import {AppRunner} from 'app/AppRunner';
import HttpException from "app/service/exceptions/HttpException";
import NoInternetConnectionException from "app/service/exceptions/NoInternetConnectionException";
import contentDisposition from 'content-disposition';
import BaseErrorTranslator from "./exceptions/BaseErrorTranslator";

/**
 * Serializers query parameters to "plain" (exploded) string.
 *
 * TODO: check openapi TS/spring generators support for other styles
 *
 * @param params
 * @see querystring
 */
function explodedQueryParamsStringify(params: HTTPQuery): string {
    return Object.keys(params)
        .map((key) => {
            const value = params[key];

            if (value instanceof Array) {
                const multiValue = value.map((singleValue) => encodeURIComponent(String(singleValue)))
                    .join(`&${encodeURIComponent(key)}=`);
                return `${encodeURIComponent(key)}=${multiValue}`;
            }
            if (value instanceof Date) {
                return `${encodeURIComponent(key)}=${encodeURIComponent(value.toISOString())}`;
            }
            if (value instanceof Object) {
                return explodedQueryParamsStringify(value as HTTPQuery);
            }

            return `${encodeURIComponent(key)}=${encodeURIComponent(String(value))}`;
        })
        .filter((part) => part.length > 0)
        .join('&');
}

const accessTokenProvider = () => auth.accessToken ?? '';

class ExceptionInterceptorMiddleware implements Middleware {

    async post(context: ResponseContext): Promise<Response | void> {
        const {response} = context;

        if (response.ok) {
            return response;
        }

        const contentType = response.headers.get('content-type');

        if (contentType != null && contentType.includes('application/json')) {
            const json = await response.json();

            if (this.isBaseError(json)) {
                throw BaseErrorTranslator.translate(json);
            }

            throw new HttpException(json.message, response.status);
        }

        const message = await response.text();
        throw new HttpException(message, response.status);
    }

    async onError(context: ErrorContext): Promise<Response | void> {
        const error = context.error;

        if (error instanceof TypeError) {

            if (error.message.includes("Failed to fetch") && !window.navigator.onLine) {
                throw new NoInternetConnectionException("Check internet connection");
            }

        }

        return context.response;
    }

    private isBaseError(input: any): input is BaseError {
        if (input == null) {
            return false;
        }

        const type = (input as BaseError).type;

        return Object.values(BaseErrorType)
            .some(it => type === it);
    }
}

class RetryWithRefreshMiddleWare implements Middleware {

    private refreshing: Promise<boolean> | null = null;

    async post(context: ResponseContext): Promise<Response | void> {
        const {status} = context.response;

        if (status !== 401) {
            return undefined;
        }

        const authorization = 'Authorization';
        const headers = context.init.headers as Record<string, string>;
        const headerAuth = headers ? headers[authorization] : null;
        if (!headerAuth) {
            return undefined;
        }

        if (!auth.isTokenExists) {
            return undefined;
        }

        if (this.refreshing == null) {
            this.refreshing = auth.refresh();
        }

        const refreshingPromise = this.refreshing;

        let refreshingSuccess: boolean;
        try {
            refreshingSuccess = await refreshingPromise;
        }
        finally {
            this.refreshing = null;
        }

        if (refreshingSuccess) {
            const token = accessTokenProvider();
            headers[authorization] = `Bearer ${token}`;
            return context.fetch(context.url, context.init);
        }

        return undefined;
    }

}


const configuration = new Configuration({
    basePath: AppRunner.appApiBasePath,
    headers: {
        'X-App-Version': AppRunner.appVersion,
        'X-App-Name': AppRunner.appName
    },
    accessToken: accessTokenProvider,
    queryParamsStringify: explodedQueryParamsStringify,
    middleware: [new RetryWithRefreshMiddleWare(), new ExceptionInterceptorMiddleware()],
});

export async function extractBlobWithFilename(response: ApiResponse<Blob>): Promise<{ blob: Blob, filename: string }> {
    const targetHeader: string = response.raw.headers.get('Content-Disposition') || '';
    const targetHeaderParsed = contentDisposition.parse(targetHeader);

    const blob: Blob = await response.value();
    const filename = targetHeaderParsed.parameters.filename ?? 'file';

    return {blob: blob, filename: filename};
}

export const authApi = new AuthApi(configuration);

export const branchOfficeApi = new BranchOfficeApi(configuration);

export const usersApi = new UsersApi(configuration);

export const catalogApi = new CatalogApi(configuration);
