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
    BranchOfficeAddress,
    BranchOfficeAddressFromJSON,
    BranchOfficeAddressFromJSONTyped,
    BranchOfficeAddressToJSON,
    ClassSchedule,
    ClassScheduleFromJSON,
    ClassScheduleFromJSONTyped,
    ClassScheduleToJSON,
} from './';


/**
 * Branch office
 * @export
 * @interface BranchOffice
 */
export interface BranchOffice {
    /**
     * 
     * @type {string}
     * @memberof BranchOffice
     */
    readonly id: string;
    /**
     * Name
     * @type {string}
     * @memberof BranchOffice
     */
    name: string;
    /**
     * 
     * @type {BranchOfficeAddress}
     * @memberof BranchOffice
     */
    address: BranchOfficeAddress;
    /**
     * Class schedules
     * @type {Array<ClassSchedule>}
     * @memberof BranchOffice
     */
    classSchedules?: Array<ClassSchedule>;
}

export function BranchOfficeFromJSON(json: any): BranchOffice {
    return BranchOfficeFromJSONTyped(json, false);
}

export function BranchOfficeFromJSONTyped(json: any, ignoreDiscriminator: boolean): BranchOffice {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['id'],
        'name': json['name'],
        'address': BranchOfficeAddressFromJSON(json['address']),
        'classSchedules': !exists(json, 'classSchedules') ? undefined : ((json['classSchedules'] as Array<any>).map(ClassScheduleFromJSON)),
    };
}

export function BranchOfficeToJSON(value?: BranchOffice | null): any {
    return BranchOfficeToJSONTyped(value, false);
}

export function BranchOfficeToJSONTyped(value?: BranchOffice | null, ignoreDiscriminator: boolean = false): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'name': value.name,
        'address': BranchOfficeAddressToJSON(value.address),
        'classSchedules': value.classSchedules === undefined ? undefined : ((value.classSchedules as Array<any>).map(ClassScheduleToJSON)),
    };
}

