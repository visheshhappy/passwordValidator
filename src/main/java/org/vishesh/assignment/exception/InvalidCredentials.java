package org.vishesh.assignment.exception;

public class InvalidCredentials extends RuntimeException {

    public enum ErrorCode {
        MIN_LENGTH,
        MIN_LOWER_CASE,
        MIN_UPPER_CASE,
        MIN_NUMBER
    }

    private ErrorCode errorCode;

    public InvalidCredentials(String s, ErrorCode code) {
        super(s);
        this.errorCode = code;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
