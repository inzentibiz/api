package com.ibiz.api.exception;

public class ApprovalAuthorizerStateException extends Exception {

    private ErrorCode errorCode;
    private String message;
    private Object errorObject;

    public ApprovalAuthorizerStateException(String message) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVAL_STATE_EXCEPTION_MESSAGE;
    }

    public ApprovalAuthorizerStateException(Object object) {
        this.errorCode = ErrorCode.APPROVAL_STATE_EXCEPTION_MESSAGE;
        this.errorObject = object;
    }

    public ApprovalAuthorizerStateException(String message, Object object) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVAL_STATE_EXCEPTION_MESSAGE;
        this.errorObject = object;
    }

}
