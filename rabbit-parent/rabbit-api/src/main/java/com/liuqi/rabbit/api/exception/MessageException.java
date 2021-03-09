package com.liuqi.rabbit.api.exception;

public class MessageException extends Exception {

    private static final long serialVersionUID = -8146638251054940176L;

    public MessageException() {
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }
}
