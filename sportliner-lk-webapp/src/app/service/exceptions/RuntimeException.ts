export default class RuntimeException extends Error {

    readonly cause: Error | undefined;

    constructor(message: string, cause?: Error) {
        super(message);

        this.cause = cause;
    }

}