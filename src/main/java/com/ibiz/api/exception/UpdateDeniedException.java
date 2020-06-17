package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class UpdateDeniedException extends Exception {


    private ErrorCode errorCode;
    private String message;
    private Object errorObject;

    public UpdateDeniedException(String message) {
        this.message = message;
        this.errorCode = ErrorCode.UPDATE_DENIED_ERROR;
    }

    public UpdateDeniedException(Object object) {
        this.errorCode = ErrorCode.UPDATE_DENIED_ERROR;
        this.errorObject = object;
    }

    public UpdateDeniedException(String message, Object object) {
        this.message = message;
        this.errorCode = ErrorCode.UPDATE_DENIED_ERROR;
        this.errorObject = object;
    }


/*

    private String errorNumber;

    public UpdateDeniedException() {
        super("변경요청이 거부되었습니다. 관리자에게 문의하세요.");

    }

    public UpdateDeniedException(String message) {
        super(message);
    }

    public String getErrorNumber() {
        return errorNumber;
    }
*/


}
