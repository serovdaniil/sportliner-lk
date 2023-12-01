import KnownErrors from "app/logic/store/KnownErrors";
import AuthenticationException from "app/service/exceptions/AuthenticationException";
import ClientVersionRejectedException from "app/service/exceptions/ClientVersionRejectedException";
import NoInternetConnectionException from "app/service/exceptions/NoInternetConnectionException";
import ObjectNotFoundException from "app/service/exceptions/ObjectNotFoundException";
import RemoteException from "app/service/exceptions/RemoteException";
import RuntimeException from "app/service/exceptions/RuntimeException";
import {ValidationException} from "app/service/exceptions/ValidationException";
import {action, computed, makeObservable, observable} from 'mobx';

export default class RequestHandlerStore {

    @observable
    isSomethingWentWrong = false;

    @observable
    is404 = false;

    @observable
    private _isRequestWithBlockingUIProcess = false;

    @observable
    private _isInitializingPageProcess = false;

    @observable
    private _isServiceRequestProcess = false;

    constructor() {
        makeObservable(this);
    }

    @action.bound
    resetErrors(): void {
        this.setIs404(false);
        this.setSomethingWentWrong(false);
    }

    @action.bound
    setSomethingWentWrong(isError: boolean): void {
        this.isSomethingWentWrong = isError;
    }

    @action.bound
    setIs404(isError: boolean): void {
        this.is404 = isError;
    }

    /**
     * Connected with overlay
     */
    @computed
    get isRequestWithBlockingUIProcess(): boolean {
        return this._isRequestWithBlockingUIProcess;
    }

    /**
     * Connected with spinner, which appears while page loading
     */
    @computed
    get isInitializingPageProcess(): boolean {
        return this._isInitializingPageProcess;
    }

    /**
     * Connected with Nprogress
     */
    @computed
    get isServiceRequestProcess(): boolean {
        return this._isServiceRequestProcess;
    }

    @computed
    get isAnythingLoading(): boolean {
        return this.isRequestWithBlockingUIProcess || this.isInitializingPageProcess || this.isServiceRequestProcess;
    }

    async serviceRequest<T>(request: () => Promise<T>): Promise<T> {
        try {
            this.setServiceRequestProcess(true);
            return await request();
        }
        finally {
            this.setServiceRequestProcess(false);
        }
    }

    async requestWithBlockingUI<T>(request: () => Promise<T>): Promise<T> {
        try {
            this.setReUploadPageProcess(true);
            return await request();
        }
        finally {
            this.setReUploadPageProcess(false);
        }
    }

    async initializePage(request: () => Promise<void>): Promise<void> {
        try {
            this.setInitializingPageProcess(true);
            await request();
        }
        catch (e: any) {
            this.setSomethingWentWrong(true);
            throw e;
        }
        finally {
            this.setInitializingPageProcess(false);
        }
    }

    @action.bound
    private setReUploadPageProcess(value: boolean): void {
        this._isRequestWithBlockingUIProcess = value;
    }

    @action.bound
    private setInitializingPageProcess(value: boolean): void {
        this._isInitializingPageProcess = value;
    }

    @action.bound
    private setServiceRequestProcess(value: boolean): void {
        this._isServiceRequestProcess = value;
    }

    /**
     * Installs a handler for unhandled exceptions that were thrown in asynchronous functions.
     *
     * @return function for removing the listeners
     */
    setUnhandledErrorsProcessing(): () => void {
        const handleOnError = (event: ErrorEvent): void => {
            return this.handleError(event.error);
        };

        const handleOnUnhandledRejection = (event: PromiseRejectionEvent): void => {
            return this.handleError(event.reason);
        }

        window.addEventListener("error", handleOnError);
        window.addEventListener("unhandledrejection", handleOnUnhandledRejection);

        return () => {
            window.removeEventListener("error", handleOnError);
            window.removeEventListener("unhandledrejection", handleOnUnhandledRejection);
        };
    }

    private handleError(error: any): void {

        if (KnownErrors.isIgnoreError(error)) {
            return;
        }

        if (error instanceof RuntimeException) {
            this.handleRuntimeException(error);
            return;
        }

        console.error("Unexpected error: ", error);
    }

    private handleRuntimeException(exception: RuntimeException): void {

        if (exception instanceof NoInternetConnectionException) {
            return;
        }

        if (exception instanceof ValidationException) {
            return;
        }

        if (exception instanceof RemoteException) {

            if (exception instanceof AuthenticationException) {
                // session expired
                return;
            }

            if (exception instanceof ObjectNotFoundException) {
                this.setIs404(true);
            }

            return;
        }

        console.error("Unexpected error: ", exception);

    }

}