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
export const PayingEntity = {
    MICHALENIA: 'MICHALENIA',
    SPORTLINER: 'SPORTLINER'
} as const;
export type PayingEntity = typeof PayingEntity[keyof typeof PayingEntity];


export function PayingEntityFromJSON(json: any): PayingEntity {
    return PayingEntityFromJSONTyped(json, false);
}

export function PayingEntityFromJSONTyped(json: any, ignoreDiscriminator: boolean): PayingEntity {
    return json as PayingEntity;
}

export function PayingEntityToJSON(value?: PayingEntity | null): any {
    return value as any;
}

