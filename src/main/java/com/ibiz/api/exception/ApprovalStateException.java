package com.ibiz.api.exception;

import lombok.Getter;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Getter
public class ApprovalStateException extends Exception {

    private ErrorCode errorCode;
    private String message;
    private Object errorObject;

    public ApprovalStateException(String message) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVAL_STATE_EXCEPTION_MESSAGE;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public ApprovalStateException(Object object) {
        this.errorCode = ErrorCode.APPROVAL_STATE_EXCEPTION_MESSAGE;
        this.errorObject = object;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public ApprovalStateException(String message, Object object) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVAL_STATE_EXCEPTION_MESSAGE;
        this.errorObject = object;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
