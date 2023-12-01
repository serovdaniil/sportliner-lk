import {DataValidationErrorItem} from "api";
import RemoteException from "app/service/exceptions/RemoteException";

export default class DataValidationException extends RemoteException {

    readonly details: DataValidationErrorItem[] | undefined;

    constructor(message: string, details?: DataValidationErrorItem[]) {
        super(message);

        this.details = details;
    }

}