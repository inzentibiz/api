package com.ibiz.api.exception;

public class ErrorResponse {

    private String message;
    private String code;
    private String application;
    private Object model;
    private String detailMessage;

    ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
        this.application = "ibiz-api-sales-order";
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ErrorResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getApplication() {
        return application;
    }

    public ErrorResponse setApplication(String application) {
        this.application = application;
        return this;
    }
    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }
}
