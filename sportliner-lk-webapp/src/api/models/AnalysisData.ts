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
 * Analysis data
 * @export
 * @interface AnalysisData
 */
export interface AnalysisData {
    /**
     * Average attendance
     * @type {number}
     * @memberof AnalysisData
     */
    averageAttendance: number;
    /**
     * Attendance by time
     * @type {{ [key: string]: number; }}
     * @memberof AnalysisData
     */
    attendanceByTime: { [key: string]: number; };
}

export function AnalysisDataFromJSON(json: any): AnalysisData {
    return AnalysisDataFromJSONTyped(json, false);
}

export function AnalysisDataFromJSONTyped(json: any, ignoreDiscriminator: boolean): AnalysisData {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'averageAttendance': json['averageAttendance'],
        'attendanceByTime': json['attendanceByTime'],
    };
}

export function AnalysisDataToJSON(value?: AnalysisData | null): any {
    return AnalysisDataToJSONTyped(value, false);
}

export function AnalysisDataToJSONTyped(value?: AnalysisData | null, ignoreDiscriminator: boolean = false): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'averageAttendance': value.averageAttendance,
        'attendanceByTime': value.attendanceByTime,
    };
}

