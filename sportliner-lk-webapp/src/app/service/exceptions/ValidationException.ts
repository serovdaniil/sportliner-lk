import RuntimeException from "app/service/exceptions/RuntimeException";

/**
 * Used for exception related to client validation
 */
export class ValidationException extends RuntimeException {

    constructor(message: string) {
        super(message);
    }

}
