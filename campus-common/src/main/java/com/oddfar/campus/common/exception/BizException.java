package com.oddfar.campus.common.exception;

public class BizException extends RuntimeException {

    private String msg;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Exception ex, String message) {
        super(ex);
        this.msg = message;
    }

    @Override
    public String getMessage() {
        if (msg == null) {
            return super.getMessage();
        }
        return msg;
    }

    public static BizException instance(String msg) {
        return new BizException(msg);
    }
}
