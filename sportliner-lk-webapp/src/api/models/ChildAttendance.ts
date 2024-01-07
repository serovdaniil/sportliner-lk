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
    Attendance,
    AttendanceFromJSON,
    AttendanceFromJSONTyped,
    AttendanceToJSON,
} from './';


/**
 * Child attendance
 * @export
 * @interface ChildAttendance
 */
export interface ChildAttendance {
    /**
     * Child ID
     * @type {string}
     * @memberof ChildAttendance
     */
    childId: string;
    /**
     * Attendances
     * @type {Array<Attendance>}
     * @memberof ChildAttendance
     */
    attendances: Array<Attendance>;
}

export function ChildAttendanceFromJSON(json: any): ChildAttendance {
    return ChildAttendanceFromJSONTyped(json, false);
}

export function ChildAttendanceFromJSONTyped(json: any, ignoreDiscriminator: boolean): ChildAttendance {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'childId': json['childId'],
        'attendances': ((json['attendances'] as Array<any>).map(AttendanceFromJSON)),
    };
}

export function ChildAttendanceToJSON(value?: ChildAttendance | null): any {
    return ChildAttendanceToJSONTyped(value, false);
}

export function ChildAttendanceToJSONTyped(value?: ChildAttendance | null, ignoreDiscriminator: boolean = false): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'childId': value.childId,
        'attendances': ((value.attendances as Array<any>).map(AttendanceToJSON)),
    };
}
