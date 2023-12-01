import RemoteException from "app/service/exceptions/RemoteException";

export default class InternalException extends RemoteException {

    constructor(message: string) {
        super(message);
    }

}