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
    BranchOfficeItem,
    BranchOfficeItemFromJSON,
    BranchOfficeItemFromJSONTyped,
    BranchOfficeItemToJSON,
} from './';


/**
 * Child
 * @export
 * @interface Child
 */
export interface Child {
    /**
     * 
     * @type {string}
     * @memberof Child
     */
    readonly id: string;
    /**
     * 
     * @type {string}
     * @memberof Child
     */
    lastName: string;
    /**
     * 
     * @type {BranchOfficeItem}
     * @memberof Child
     */
    branchOffice?: BranchOfficeItem;
    /**
     * 
     * @type {string}
     * @memberof Child
     */
    firstName: string;
    /**
     * 
     * @type {string}
     * @memberof Child
     */
    patronymic: string;
    /**
     * A date without a time-zone in the ISO-8601 calendar system.

     * @type {string}
     * @memberof Child
     */
    birthdate?: string;
    /**
     * 
     * @type {string}
     * @memberof Child
     */
    diagnosis: string;
    /**
     * 
     * @type {number}
     * @memberof Child
     */
    tuitionBalance: number;
    /**
     * 
     * @type {number}
     * @memberof Child
     */
    numberClassesPerMonth: number;
    /**
     * 
     * @type {string}
     * @memberof Child
     */
    notes?: string;
}

export function ChildFromJSON(json: any): Child {
    return ChildFromJSONTyped(json, false);
}

export function ChildFromJSONTyped(json: any, ignoreDiscriminator: boolean): Child {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['id'],
        'lastName': json['lastName'],
        'branchOffice': !exists(json, 'branchOffice') ? undefined : BranchOfficeItemFromJSON(json['branchOffice']),
        'firstName': json['firstName'],
        'patronymic': json['patronymic'],
        'birthdate': !exists(json, 'birthdate') ? undefined : json['birthdate'],
        'diagnosis': json['diagnosis'],
        'tuitionBalance': json['tuitionBalance'],
        'numberClassesPerMonth': json['numberClassesPerMonth'],
        'notes': !exists(json, 'notes') ? undefined : json['notes'],
    };
}

export function ChildToJSON(value?: Child | null): any {
    return ChildToJSONTyped(value, false);
}

export function ChildToJSONTyped(value?: Child | null, ignoreDiscriminator: boolean = false): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'lastName': value.lastName,
        'branchOffice': BranchOfficeItemToJSON(value.branchOffice),
        'firstName': value.firstName,
        'patronymic': value.patronymic,
        'birthdate': value.birthdate,
        'diagnosis': value.diagnosis,
        'tuitionBalance': value.tuitionBalance,
        'numberClassesPerMonth': value.numberClassesPerMonth,
        'notes': value.notes,
    };
}

