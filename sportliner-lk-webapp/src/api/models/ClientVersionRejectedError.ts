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

import { exists, mapValues } from '../runtime';
import {
    BaseError,
    BaseErrorFromJSON,
    BaseErrorFromJSONTyped,
    BaseErrorToJSON,
    BaseErrorType,
    BaseErrorTypeFromJSON,
    BaseErrorTypeFromJSONTyped,
    BaseErrorTypeToJSON,
} from './';
import { BaseErrorToJSONTyped } from './';

/**
 * 
 * @export
 * @interface ClientVersionRejectedError
 */
export interface ClientVersionRejectedError extends BaseError {
}

export function ClientVersionRejectedErrorFromJSON(json: any): ClientVersionRejectedError {
    return ClientVersionRejectedErrorFromJSONTyped(json, false);
}

export function ClientVersionRejectedErrorFromJSONTyped(json: any, ignoreDiscriminator: boolean): ClientVersionRejectedError {
    return json;
}

export function ClientVersionRejectedErrorToJSON(value?: ClientVersionRejectedError | null): any {
    return ClientVersionRejectedErrorToJSONTyped(value, false);
}

export function ClientVersionRejectedErrorToJSONTyped(value?: ClientVersionRejectedError | null, ignoreDiscriminator: boolean = false): any {
    return value;
}

