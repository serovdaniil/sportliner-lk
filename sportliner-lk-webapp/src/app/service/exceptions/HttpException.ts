import RuntimeException from "app/service/exceptions/RuntimeException";

export default class HttpException extends RuntimeException {

    readonly status: number;

    constructor(message: string, status: number) {
        super(message);

        this.status = status;
    }

}