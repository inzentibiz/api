package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class ApprovalStateException extends Exception {

    private ErrorCode errorCode;
    private String message;
    private Object errorObject;

    public ApprovalStateException(String message) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVER_STATE_EXCEPTION_MESSAGE;
    }

    public ApprovalStateException(Object object) {
        this.errorCode = ErrorCode.APPROVER_STATE_EXCEPTION_MESSAGE;
        this.errorObject = object;
    }

    public ApprovalStateException(String message, Object object) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVER_STATE_EXCEPTION_MESSAGE;
        this.errorObject = object;
    }
}
