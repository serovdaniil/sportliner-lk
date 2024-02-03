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


/**
 * 
 * @export
 */
export const TrialAttendanceStatus = {
    ATTENDED: 'ATTENDED',
    PAID: 'PAID',
    UNPAID: 'UNPAID'
} as const;
export type TrialAttendanceStatus = typeof TrialAttendanceStatus[keyof typeof TrialAttendanceStatus];


export function TrialAttendanceStatusFromJSON(json: any): TrialAttendanceStatus {
    return TrialAttendanceStatusFromJSONTyped(json, false);
}

export function TrialAttendanceStatusFromJSONTyped(json: any, ignoreDiscriminator: boolean): TrialAttendanceStatus {
    return json as TrialAttendanceStatus;
}

export function TrialAttendanceStatusToJSON(value?: TrialAttendanceStatus | null): any {
    return value as any;
}

