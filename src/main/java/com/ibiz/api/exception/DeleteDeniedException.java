package com.ibiz.api.exception;

import lombok.Getter;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Getter
public class DeleteDeniedException extends Exception {

    private ErrorCode errorCode;
    private String message;
    private Object errorObject;

    public DeleteDeniedException(String message) {
        this.message = message;
        this.errorCode = ErrorCode.DELETE_DENIED_ERROR;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public DeleteDeniedException(Object object) {
        this.errorCode = ErrorCode.DELETE_DENIED_ERROR;
        this.errorObject = object;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public DeleteDeniedException(String message, Object object) {
        this.message = message;
        this.errorCode = ErrorCode.DELETE_DENIED_ERROR;
        this.errorObject = object;
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
    /*private String errorNumber;

    public DeleteDeniedException(String message) {
        super(message);
        this.errorNumber = ExceptionCode.DELETE_DENIED_EXCEPTION;
    }


    public DeleteDeniedException() {
        super(ExceptionCode.DELETE_DENIED_EXCEPTION_MESSAGE);
        this.errorNumber = ExceptionCode.DELETE_DENIED_EXCEPTION;
    }

    public String getErrorNumber() {
        return errorNumber;
    }
    */
}
