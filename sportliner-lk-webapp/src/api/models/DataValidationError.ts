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
    DataValidationErrorItem,
    DataValidationErrorItemFromJSON,
    DataValidationErrorItemFromJSONTyped,
    DataValidationErrorItemToJSON,
} from './';
import { BaseErrorToJSONTyped } from './';

/**
 * 
 * @export
 * @interface DataValidationError
 */
export interface DataValidationError extends BaseError {
    /**
     * 
     * @type {Array<DataValidationErrorItem>}
     * @memberof DataValidationError
     */
    details?: Array<DataValidationErrorItem>;
}

export function DataValidationErrorFromJSON(json: any): DataValidationError {
    return DataValidationErrorFromJSONTyped(json, false);
}

export function DataValidationErrorFromJSONTyped(json: any, ignoreDiscriminator: boolean): DataValidationError {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        ...BaseErrorFromJSONTyped(json, ignoreDiscriminator),
        'details': !exists(json, 'details') ? undefined : ((json['details'] as Array<any>).map(DataValidationErrorItemFromJSON)),
    };
}

export function DataValidationErrorToJSON(value?: DataValidationError | null): any {
    return DataValidationErrorToJSONTyped(value, false);
}

export function DataValidationErrorToJSONTyped(value?: DataValidationError | null, ignoreDiscriminator: boolean = false): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        ...BaseErrorToJSONTyped(value, ignoreDiscriminator),
        'details': value.details === undefined ? undefined : ((value.details as Array<any>).map(DataValidationErrorItemToJSON)),
    };
}

