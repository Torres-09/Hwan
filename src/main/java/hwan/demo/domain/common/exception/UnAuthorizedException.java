package hwan.demo.domain.common.exception;


public class UnAuthorizedException extends HwanBaseException {

    public UnAuthorizedException(String message) {
        super(message, ErrorCode.E401_UNAUTHORIZED);
    }

}
