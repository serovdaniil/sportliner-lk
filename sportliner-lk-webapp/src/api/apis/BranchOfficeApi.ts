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
  BranchOffice,
  BranchOfficeItem,
  BranchOfficeListItem,
  ChildInfo,
} from '../models';
import {
    BranchOfficeFromJSON,
    BranchOfficeToJSON,
    BranchOfficeItemFromJSON,
    BranchOfficeItemToJSON,
    BranchOfficeListItemFromJSON,
    BranchOfficeListItemToJSON,
    ChildInfoFromJSON,
    ChildInfoToJSON,
} from '../models';

export interface CreateBranchOfficeRequest {
    branchOffice: BranchOffice;
}

export interface DeleteBranchOfficeRequest {
    id: string;
}

export interface GetBranchOfficeRequest {
    id: string;
}

export interface GetChildrenForBranchOfficeRequest {
    id: string;
}

export interface GetSchedulesForBranchOfficeRequest {
    id: string;
    period: string;
}

export interface UpdateBranchOfficeRequest {
    id: string;
    branchOffice: BranchOffice;
}

/**
 * 
 */
export class BranchOfficeApi extends runtime.BaseAPI {

    /**
     * Create branch office
     */
    async createBranchOfficeRaw(requestParameters: CreateBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.branchOffice === null || requestParameters.branchOffice === undefined) {
            throw new runtime.RequiredError('branchOffice','Required parameter requestParameters.branchOffice was null or undefined when calling createBranchOffice.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("bearerAuth", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/branchOffices`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: BranchOfficeToJSON(requestParameters.branchOffice),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Create branch office
     */
    async createBranchOffice(requestParameters: CreateBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.createBranchOfficeRaw(requestParameters, initOverrides);
    }

    /**
     * Delete branch office by ID
     */
    async deleteBranchOfficeRaw(requestParameters: DeleteBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling deleteBranchOffice.');
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
            path: `/branchOffices/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'DELETE',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Delete branch office by ID
     */
    async deleteBranchOffice(requestParameters: DeleteBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.deleteBranchOfficeRaw(requestParameters, initOverrides);
    }

    /**
     * Get branch office by ID
     */
    async getBranchOfficeRaw(requestParameters: GetBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<BranchOffice>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling getBranchOffice.');
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
            path: `/branchOffices/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => BranchOfficeFromJSON(jsonValue));
    }

    /**
     * Get branch office by ID
     */
    async getBranchOffice(requestParameters: GetBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<BranchOffice> {
        const response = await this.getBranchOfficeRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get branch office of current trainer
     */
    async getBranchOfficeOfCurrentTrainerRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<BranchOfficeItem>> {
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
            path: `/branchOffices/currentTrainer`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => BranchOfficeItemFromJSON(jsonValue));
    }

    /**
     * Get branch office of current trainer
     */
    async getBranchOfficeOfCurrentTrainer(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<BranchOfficeItem> {
        const response = await this.getBranchOfficeOfCurrentTrainerRaw(initOverrides);
        return await response.value();
    }

    /**
     * Get branch offices
     */
    async getBranchOfficesRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<BranchOfficeListItem>>> {
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
            path: `/branchOffices`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(BranchOfficeListItemFromJSON));
    }

    /**
     * Get branch offices
     */
    async getBranchOffices(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<BranchOfficeListItem>> {
        const response = await this.getBranchOfficesRaw(initOverrides);
        return await response.value();
    }

    /**
     * Get children for branch office
     */
    async getChildrenForBranchOfficeRaw(requestParameters: GetChildrenForBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<ChildInfo>>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling getChildrenForBranchOffice.');
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
            path: `/branchOffices/{id}/children`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(ChildInfoFromJSON));
    }

    /**
     * Get children for branch office
     */
    async getChildrenForBranchOffice(requestParameters: GetChildrenForBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<ChildInfo>> {
        const response = await this.getChildrenForBranchOfficeRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get schedules for branch office
     */
    async getSchedulesForBranchOfficeRaw(requestParameters: GetSchedulesForBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<{ [key: string]: Array<string>; }>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling getSchedulesForBranchOffice.');
        }

        if (requestParameters.period === null || requestParameters.period === undefined) {
            throw new runtime.RequiredError('period','Required parameter requestParameters.period was null or undefined when calling getSchedulesForBranchOffice.');
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
            path: `/branchOffices/{id}/schedules/{period}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))).replace(`{${"period"}}`, encodeURIComponent(String(requestParameters.period))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse<any>(response);
    }

    /**
     * Get schedules for branch office
     */
    async getSchedulesForBranchOffice(requestParameters: GetSchedulesForBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<{ [key: string]: Array<string>; }> {
        const response = await this.getSchedulesForBranchOfficeRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Update branch office by ID
     */
    async updateBranchOfficeRaw(requestParameters: UpdateBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling updateBranchOffice.');
        }

        if (requestParameters.branchOffice === null || requestParameters.branchOffice === undefined) {
            throw new runtime.RequiredError('branchOffice','Required parameter requestParameters.branchOffice was null or undefined when calling updateBranchOffice.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("bearerAuth", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/branchOffices/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: BranchOfficeToJSON(requestParameters.branchOffice),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Update branch office by ID
     */
    async updateBranchOffice(requestParameters: UpdateBranchOfficeRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.updateBranchOfficeRaw(requestParameters, initOverrides);
    }

}
