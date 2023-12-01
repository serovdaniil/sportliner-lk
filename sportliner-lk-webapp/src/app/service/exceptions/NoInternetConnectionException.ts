import RuntimeException from "app/service/exceptions/RuntimeException";

export default class NoInternetConnectionException extends RuntimeException {

    constructor(message: string) {
        super(message);
    }

}