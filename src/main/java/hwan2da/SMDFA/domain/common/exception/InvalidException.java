package hwan2da.SMDFA.domain.common.exception;

public class InvalidException extends HwanBaseException {

    public InvalidException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}