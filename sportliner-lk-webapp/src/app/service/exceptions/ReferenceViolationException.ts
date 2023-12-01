import RemoteException from "app/service/exceptions/RemoteException";

export default class ReferenceViolationException extends RemoteException {

    constructor(message: string) {
        super(message);
    }

}