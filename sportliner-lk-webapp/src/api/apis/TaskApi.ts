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
  Task,
  TaskStatus,
} from '../models';
import {
    TaskFromJSON,
    TaskToJSON,
    TaskStatusFromJSON,
    TaskStatusToJSON,
} from '../models';

export interface CreateTaskRequest {
    task: Task;
}

export interface GetTaskByIdRequest {
    id: string;
}

export interface UpdateStatusTaskByIdRequest {
    id: string;
    status: TaskStatus;
}

export interface UpdateTaskRequest {
    id: string;
    task: Task;
}

/**
 * 
 */
export class TaskApi extends runtime.BaseAPI {

    /**
     * Create task
     */
    async createTaskRaw(requestParameters: CreateTaskRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.task === null || requestParameters.task === undefined) {
            throw new runtime.RequiredError('task','Required parameter requestParameters.task was null or undefined when calling createTask.');
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
            path: `/task`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TaskToJSON(requestParameters.task),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Create task
     */
    async createTask(requestParameters: CreateTaskRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.createTaskRaw(requestParameters, initOverrides);
    }

    /**
     * Find all tasks
     */
    async findAllRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<Task>>> {
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
            path: `/task`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(TaskFromJSON));
    }

    /**
     * Find all tasks
     */
    async findAll(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<Task>> {
        const response = await this.findAllRaw(initOverrides);
        return await response.value();
    }

    /**
     * Get task by ID
     */
    async getTaskByIdRaw(requestParameters: GetTaskByIdRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Task>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling getTaskById.');
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
            path: `/task/:{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TaskFromJSON(jsonValue));
    }

    /**
     * Get task by ID
     */
    async getTaskById(requestParameters: GetTaskByIdRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Task> {
        const response = await this.getTaskByIdRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Update status task by ID
     */
    async updateStatusTaskByIdRaw(requestParameters: UpdateStatusTaskByIdRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling updateStatusTaskById.');
        }

        if (requestParameters.status === null || requestParameters.status === undefined) {
            throw new runtime.RequiredError('status','Required parameter requestParameters.status was null or undefined when calling updateStatusTaskById.');
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
            path: `/task/:{id}/:{status}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))).replace(`{${"status"}}`, encodeURIComponent(String(requestParameters.status))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Update status task by ID
     */
    async updateStatusTaskById(requestParameters: UpdateStatusTaskByIdRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.updateStatusTaskByIdRaw(requestParameters, initOverrides);
    }

    /**
     * Update task
     */
    async updateTaskRaw(requestParameters: UpdateTaskRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.id === null || requestParameters.id === undefined) {
            throw new runtime.RequiredError('id','Required parameter requestParameters.id was null or undefined when calling updateTask.');
        }

        if (requestParameters.task === null || requestParameters.task === undefined) {
            throw new runtime.RequiredError('task','Required parameter requestParameters.task was null or undefined when calling updateTask.');
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
            path: `/task/:{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters.id))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: TaskToJSON(requestParameters.task),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Update task
     */
    async updateTask(requestParameters: UpdateTaskRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.updateTaskRaw(requestParameters, initOverrides);
    }

}
