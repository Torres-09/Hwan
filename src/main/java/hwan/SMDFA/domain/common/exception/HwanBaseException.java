package hwan.SMDFA.domain.common.exception;

import lombok.Getter;

@Getter
public abstract class HwanBaseException extends RuntimeException{
    private final ErrorCode errorCode;

    protected HwanBaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return errorCode.getStatus();
    }
}
