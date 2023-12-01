import RuntimeException from "app/service/exceptions/RuntimeException";

export default class RemoteException extends RuntimeException {

    protected constructor(message: string) {
        super(message);
    }

}