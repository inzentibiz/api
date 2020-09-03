package com.ibiz.api.exception;

import lombok.Getter;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Getter
public class ApprovalSaveException extends Exception {

    private ErrorCode errorCode;
    private String message;
    private Object errorObject;

    public ApprovalSaveException(String message) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVAL_SAVE_EXCEPTION_MESSAGE;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public ApprovalSaveException(Object object) {
        this.errorCode = ErrorCode.APPROVAL_SAVE_EXCEPTION_MESSAGE;
        this.errorObject = object;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

    }

    public ApprovalSaveException(String message, Object object) {
        this.message = message;
        this.errorCode = ErrorCode.APPROVAL_SAVE_EXCEPTION_MESSAGE;
        this.errorObject = object;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
