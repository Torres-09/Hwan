package hwan.SMDFA.domain.common.exception;

public class InternalServerException extends HwanBaseException {

    public InternalServerException(String message) {
        super(message, ErrorCode.E500_INTERNAL_SERVER);
    }
}
