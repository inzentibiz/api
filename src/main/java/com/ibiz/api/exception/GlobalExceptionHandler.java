package com.ibiz.api.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.SYSTEM_FAILURE);

        //logger.error((Supplier<String>) e);
        return new ResponseEntity<>(errorResponse, ErrorCode.SYSTEM_FAILURE.getStatus());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.SQL_INVALID);

        // 응답헤더 지정
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        if(e.getMessage() != null){ // null error
            errorResponse.setMessage("Data Integrity Error");
            errorResponse.setDetailMessage(e.getMessage());
        }

        return new ResponseEntity<>(errorResponse, resHeaders,ErrorCode.SQL_INVALID.getStatus());
    }

    @ExceptionHandler(value = UncategorizedSQLException.class)
    public ResponseEntity<ErrorResponse> handleUncategorizedSQLException(UncategorizedSQLException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.SQL_INVALID);

        // 응답헤더 지정
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        if(e.getMessage() != null){ // data length
            errorResponse.setMessage("Data Uncategorized Error");
            errorResponse.setDetailMessage(e.getMessage());
        }

        return new ResponseEntity<>(errorResponse, resHeaders,ErrorCode.SQL_INVALID.getStatus());
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    public ResponseEntity<ErrorResponse> handleBadSqlGrammarException(BadSqlGrammarException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.SQL_INVALID);

        // 응답헤더 지정
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        if(e.getMessage() != null){
            errorResponse.setMessage("Query Error");
            errorResponse.setDetailMessage(e.getMessage());
        }

        return new ResponseEntity<>(errorResponse, resHeaders,ErrorCode.SQL_INVALID.getStatus());
    }
    @ExceptionHandler(value = InvalidMessageStructureException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMessageStructureException(InvalidMessageStructureException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());

        //logger.error((Supplier<String>) e);
        return new ResponseEntity<>(errorResponse, e.getErrorCode().getStatus());
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> handleExpiredJwtException(ExpiredJwtException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.ACCESS_TOKEN_EXPIRED);

        //logger.error((Supplier<String>) e);
        return new ResponseEntity<>(errorResponse, ErrorCode.ACCESS_TOKEN_EXPIRED.getStatus());
    }

    @ExceptionHandler(value = UnauthorizedCilentException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedCilentException(UnauthorizedCilentException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());

        //logger.error((Supplier<String>) e);
        return new ResponseEntity<>(errorResponse, e.getErrorCode().getStatus());
    }

    @ExceptionHandler(value = DeleteDeniedException.class)
    public ResponseEntity<ErrorResponse> handleDeleteDeniedException(DeleteDeniedException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        // 응답헤더 지정
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        if(e.getMessage() != null){
            errorResponse.setMessage(e.getMessage());
        }
        errorResponse.setModel(e.getErrorObject());

        return new ResponseEntity<>(errorResponse, resHeaders, e.getErrorCode().getStatus());
    }

    @ExceptionHandler(value = UpdateDeniedException.class)
    public ResponseEntity<ErrorResponse> handleUpdateDeniedException(UpdateDeniedException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        // 응답헤더 지정
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        if(e.getMessage() != null){
            errorResponse.setMessage(e.getMessage());
        }
        errorResponse.setModel(e.getErrorObject());

        return new ResponseEntity<>(errorResponse, resHeaders, e.getErrorCode().getStatus());
    }
}


