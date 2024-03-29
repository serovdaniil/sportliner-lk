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


/**
 * 
 * @export
 * @interface AuthInfo
 */
export interface AuthInfo {
    /**
     * 
     * @type {string}
     * @memberof AuthInfo
     */
    id: string;
    /**
     * 
     * @type {string}
     * @memberof AuthInfo
     */
    username: string;
    /**
     * 
     * @type {string}
     * @memberof AuthInfo
     */
    firstName: string;
    /**
     * 
     * @type {string}
     * @memberof AuthInfo
     */
    lastName: string;
    /**
     * 
     * @type {string}
     * @memberof AuthInfo
     */
    avatarId?: string;
    /**
     * 
     * @type {Array<string>}
     * @memberof AuthInfo
     */
    authorities: Array<string>;
}

export function AuthInfoFromJSON(json: any): AuthInfo {
    return AuthInfoFromJSONTyped(json, false);
}

export function AuthInfoFromJSONTyped(json: any, ignoreDiscriminator: boolean): AuthInfo {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['id'],
        'username': json['username'],
        'firstName': json['firstName'],
        'lastName': json['lastName'],
        'avatarId': !exists(json, 'avatarId') ? undefined : json['avatarId'],
        'authorities': json['authorities'],
    };
}

export function AuthInfoToJSON(value?: AuthInfo | null): any {
    return AuthInfoToJSONTyped(value, false);
}

export function AuthInfoToJSONTyped(value?: AuthInfo | null, ignoreDiscriminator: boolean = false): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id': value.id,
        'username': value.username,
        'firstName': value.firstName,
        'lastName': value.lastName,
        'avatarId': value.avatarId,
        'authorities': value.authorities,
    };
}

