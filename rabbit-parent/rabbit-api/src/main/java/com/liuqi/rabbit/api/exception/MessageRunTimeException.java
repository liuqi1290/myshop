package com.liuqi.rabbit.api.exception;

public class MessageRunTimeException extends RuntimeException {

    private static final long serialVersionUID = -9019878625769035691L;

    public MessageRunTimeException() {
    }

    public MessageRunTimeException(String message) {
        super(message);
    }

    public MessageRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageRunTimeException(Throwable cause) {
        super(cause);
    }
}
