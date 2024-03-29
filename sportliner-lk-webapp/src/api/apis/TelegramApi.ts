/* tslint:disable */
/* eslint-disable */
/**
 * Sportliner-lk-endpoint-api
 * Sportliner LK Endpoint API
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  TelegramBotApplication,
} from '../models';
import {
    TelegramBotApplicationFromJSON,
    TelegramBotApplicationToJSON,
} from '../models';

export interface GetTelegramApplicationByIdRequest {
    telegramBotApplicationId: string;
}

/**
 * 
 */
export class TelegramApi extends runtime.BaseAPI {

    /**
     * Get application from telegram bot by ID
     */
    async getTelegramApplicationByIdRaw(requestParameters: GetTelegramApplicationByIdRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TelegramBotApplication>> {
        if (requestParameters.telegramBotApplicationId === null || requestParameters.telegramBotApplicationId === undefined) {
            throw new runtime.RequiredError('telegramBotApplicationId','Required parameter requestParameters.telegramBotApplicationId was null or undefined when calling getTelegramApplicationById.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("bearerAuth", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/telegram/application/{telegramBotApplicationId}`.replace(`{${"telegramBotApplicationId"}}`, encodeURIComponent(String(requestParameters.telegramBotApplicationId))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TelegramBotApplicationFromJSON(jsonValue));
    }

    /**
     * Get application from telegram bot by ID
     */
    async getTelegramApplicationById(requestParameters: GetTelegramApplicationByIdRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TelegramBotApplication> {
        const response = await this.getTelegramApplicationByIdRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get applications from telegram bot
     */
    async getTelegramApplicationsRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<TelegramBotApplication>>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("bearerAuth", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/telegram/application`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(TelegramBotApplicationFromJSON));
    }

    /**
     * Get applications from telegram bot
     */
    async getTelegramApplications(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<TelegramBotApplication>> {
        const response = await this.getTelegramApplicationsRaw(initOverrides);
        return await response.value();
    }

}
