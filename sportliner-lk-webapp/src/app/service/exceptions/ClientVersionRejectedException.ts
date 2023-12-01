import RemoteException from "app/service/exceptions/RemoteException";

export default class ClientVersionRejectedException extends RemoteException {

    constructor(message: string) {
        super(message);
    }

}