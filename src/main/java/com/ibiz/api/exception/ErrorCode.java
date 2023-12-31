package com.ibiz.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    SYSTEM_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, "000", "System error"),
    INVALID_MESSAGE_STRUCTURE(HttpStatus.PRECONDITION_FAILED, "100", "Invalid message structure."),
    RESOURCE_ACCESS_DENIED(HttpStatus.UNAUTHORIZED, "200", "Access is denied."),
    UNAUTHORIZED_CLIENT_ID(HttpStatus.UNAUTHORIZED, "201", "The client id is Unregistered"),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "202", "The access token is expired"),
    SQL_INVALID(HttpStatus.BAD_REQUEST, "203", "The request is bad"),

    DELETE_DENIED_ERROR(HttpStatus.UNAUTHORIZED, "333", "삭제가 불가능합니다"),
    UPDATE_DENIED_ERROR(HttpStatus.UNAUTHORIZED, "333", "수정이 불가능합니다"),

    APPROVAL_STATE_EXCEPTION_MESSAGE(HttpStatus.UNAUTHORIZED, "333", "결재정보가 변경되어 결재진행이 불가능합니다."),
    APPROVAL_SAVE_EXCEPTION_MESSAGE(HttpStatus.UNAUTHORIZED, "333", "결재정보 변경 중 오류가 발생했습니다.");
    
    private final HttpStatus status;
    private final String code;
    private final String message;

    private ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


}
