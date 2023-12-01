import {AuthenticationError, BaseError, BaseErrorType, DataValidationError} from "api";
import AuthenticationException from "app/service/exceptions/AuthenticationException";
import ClientVersionRejectedException from "app/service/exceptions/ClientVersionRejectedException";
import DataValidationException from "app/service/exceptions/DataValidationException";
import InternalException from "app/service/exceptions/InternalException";
import ObjectNotFoundException from "app/service/exceptions/ObjectNotFoundException";
import ReferenceViolationException from "app/service/exceptions/ReferenceViolationException";
import RemoteException from "app/service/exceptions/RemoteException";
import RuntimeException from "app/service/exceptions/RuntimeException";
import UniquenessViolationException from "app/service/exceptions/UniquenessViolationException";

export default class BaseErrorTranslator {

    static translate(baseError: BaseError): RemoteException {
        const {message, type} = baseError;

        if (BaseErrorType.AUTHENTICATION === type) {
            const reason = (baseError as AuthenticationError).reason;

            return new AuthenticationException(message, reason);
        }

        if (BaseErrorType.OBJECT_NOT_FOUND === type) {
            return new ObjectNotFoundException(message);
        }

        if (BaseErrorType.UNIQUENESS_VIOLATION === type) {
            return new UniquenessViolationException(message);
        }

        if (BaseErrorType.REFERENCE_VIOLATION === type) {
            return new ReferenceViolationException(message);
        }

        if (BaseErrorType.DATA_VALIDATION === type) {
            const details = (baseError as DataValidationError).details;

            return new DataValidationException(message, details);
        }

        if (BaseErrorType.CLIENT_VERSION_REJECTED === type) {
            return new ClientVersionRejectedException(message);
        }

        if (BaseErrorType.INTERNAL === type) {
            return new InternalException(message);
        }

        throw new RuntimeException("Failed to process exception! " + type);
    }

}