import RemoteException from "app/service/exceptions/RemoteException";
import {AuthenticationErrorReason} from "../../../api";

export default class AuthenticationException extends RemoteException {

    readonly reason: AuthenticationErrorReason;

    constructor(message: string, reason: AuthenticationErrorReason) {
        super(message);

        this.reason = reason;
    }

}