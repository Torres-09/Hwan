package hwan.demo.domain.common.exception;

import lombok.Getter;

@Getter
public abstract class HwanBaseException extends RuntimeException{
    private final ErrorCode errorCode;

    public HwanBaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return errorCode.getStatus();
    }
}
