/**
 * A list of known errors to ignore.
 */
const KNOWN_ERRORS = new Set(["ResizeObserver loop limit exceeded"])

export default class KnownErrors {

    /**
     * Checks whether this error needs to be ignored.
     *
     * @param error error event
     */
    public static isIgnoreError(error: any): boolean {
        return KNOWN_ERRORS.has(error.message);
    }

}
