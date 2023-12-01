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
 * @interface UniquenessViolationError
 */
export interface UniquenessViolationError extends BaseError {
}

export function UniquenessViolationErrorFromJSON(json: any): UniquenessViolationError {
    return UniquenessViolationErrorFromJSONTyped(json, false);
}

export function UniquenessViolationErrorFromJSONTyped(json: any, ignoreDiscriminator: boolean): UniquenessViolationError {
    return json;
}

export function UniquenessViolationErrorToJSON(value?: UniquenessViolationError | null): any {
    return UniquenessViolationErrorToJSONTyped(value, false);
}

export function UniquenessViolationErrorToJSONTyped(value?: UniquenessViolationError | null, ignoreDiscriminator: boolean = false): any {
    return value;
}

