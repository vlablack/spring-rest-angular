package org.library.rest.api.common.exception;

public class LibraryApiException extends RuntimeException {

    private static final long serialVersionUID = -7208474773597069342L;

    public LibraryApiException() {
    }

    public LibraryApiException(String message) {
        super(message);
    }

    public LibraryApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryApiException(Throwable cause) {
        super(cause);
    }
}
