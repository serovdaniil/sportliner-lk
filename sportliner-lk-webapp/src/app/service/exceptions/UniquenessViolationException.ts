import RemoteException from "app/service/exceptions/RemoteException";

export default class UniquenessViolationException extends RemoteException {

    constructor(message: string) {
        super(message);
    }

}