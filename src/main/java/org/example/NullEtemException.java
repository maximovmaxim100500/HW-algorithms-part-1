package org.example;

public class NullEtemException extends RuntimeException {
    public NullEtemException() {
    }

    public NullEtemException(String message) {
        super(message);
    }

    public NullEtemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullEtemException(Throwable cause) {
        super(cause);
    }

    public NullEtemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
