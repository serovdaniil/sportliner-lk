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
  Versions,
} from '../models';
import {
    VersionsFromJSON,
    VersionsToJSON,
} from '../models';

/**
 * 
 */
export class MetaApi extends runtime.BaseAPI {

    /**
     */
    async getVersionsRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Versions>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/version`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => VersionsFromJSON(jsonValue));
    }

    /**
     */
    async getVersions(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Versions> {
        const response = await this.getVersionsRaw(initOverrides);
        return await response.value();
    }

}
