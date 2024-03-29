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
  UserAccount,
  UserAccountCriteria,
  UserAccountListItem,
} from '../models';
import {
    UserAccountFromJSON,
    UserAccountToJSON,
    UserAccountCriteriaFromJSON,
    UserAccountCriteriaToJSON,
    UserAccountListItemFromJSON,
    UserAccountListItemToJSON,
} from '../models';

export interface CreateUserRequest {
    userAccount: UserAccount;
}

export interface DeleteUserRequest {
    id: string;
}

export interface GetUserAccountRequest {
    id: string;
}

export interface GetUsersRequest {
    criteria: UserAccountCriteria;
}

export interface UpdateUserAccountRequest {
    id: string;
    userAccount: UserAccount;
}

/**
 * 
 */
export class UsersApi extends runtime.BaseAPI {

    /**
     * Create User
     */
    async createUserRaw(requestParameters: CreateUserRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.userAccount === null || requestParameters.userAccount === undefined) {
            throw new runtime.RequiredError('userAccount','Required parameter requestParameters.userAccount was null or undefined when calling createUser.');
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
            path: `/users`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: UserAccountToJSON(requestParameters.userAccount),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Create User
     */
    async createUser(requestParameters: CreateUserRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.createUserRaw(requestParameters, initOverrides);
    }

    /**
     * Delete user by ID
     */
    async deleteUserRaw(requestParameters: DeleteUserRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling deleteUser.');
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
            path: `/users/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'DELETE',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Delete user by ID
     */
    async deleteUser(requestParameters: DeleteUserRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.deleteUserRaw(requestParameters, initOverrides);
    }

    /**
     * Get user account by ID
     */
    async getUserAccountRaw(requestParameters: GetUserAccountRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<UserAccount>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling getUserAccount.');
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
            path: `/users/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => UserAccountFromJSON(jsonValue));
    }

    /**
     * Get user account by ID
     */
    async getUserAccount(requestParameters: GetUserAccountRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<UserAccount> {
        const response = await this.getUserAccountRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get users accounts
     */
    async getUsersRaw(requestParameters: GetUsersRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<UserAccountListItem>>> {
        if (requestParameters.criteria === null || requestParameters.criteria === undefined) {
            throw new runtime.RequiredError('criteria','Required parameter requestParameters.criteria was null or undefined when calling getUsers.');
        }

        const queryParameters: any = {};

        if (requestParameters.criteria !== undefined) {
            queryParameters['criteria'] = requestParameters.criteria;
        }

        const headerParameters: runtime.HTTPHeaders = {};

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("bearerAuth", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/users`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(UserAccountListItemFromJSON));
    }

    /**
     * Get users accounts
     */
    async getUsers(requestParameters: GetUsersRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<UserAccountListItem>> {
        const response = await this.getUsersRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Update user account by ID
     */
    async updateUserAccountRaw(requestParameters: UpdateUserAccountRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling updateUserAccount.');
        }

        if (requestParameters.userAccount === null || requestParameters.userAccount === undefined) {
            throw new runtime.RequiredError('userAccount','Required parameter requestParameters.userAccount was null or undefined when calling updateUserAccount.');
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
            path: `/users/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: UserAccountToJSON(requestParameters.userAccount),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Update user account by ID
     */
    async updateUserAccount(requestParameters: UpdateUserAccountRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.updateUserAccountRaw(requestParameters, initOverrides);
    }

}
