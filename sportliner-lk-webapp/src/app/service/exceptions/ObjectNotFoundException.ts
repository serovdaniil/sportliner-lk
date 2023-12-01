import RemoteException from "app/service/exceptions/RemoteException";

export default class ObjectNotFoundException extends RemoteException {

    constructor(message: string) {
        super(message);
    }

}