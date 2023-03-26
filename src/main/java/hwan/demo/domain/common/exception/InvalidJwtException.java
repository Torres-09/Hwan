package hwan.demo.domain.common.exception;

public class InvalidJwtException extends HwanBaseException{

    public InvalidJwtException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
