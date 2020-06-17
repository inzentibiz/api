package com.ibiz.api.exception;

public class ViewSynchronizationException extends Exception {
    private String errorNumber;

    private String returnUrl;
    private String loginUrl;
    private String parameterName;
    private String message;

    public ViewSynchronizationException() {
        super(ExceptionCode.COMMON_VIEW_SYNCHRONIZATION_EXCEPTION_MESSAGE);
        this.errorNumber = ExceptionCode.COMMON_VIEW_SYNCHRONIZATION_EXCEPTION;
    }

    public String getErrorNumber() {
        return errorNumber;
    }

    public ViewSynchronizationException(String loginUrl, String returnUrl, String parameterName) {

        this.loginUrl = loginUrl;
        this.returnUrl = returnUrl;
        this.parameterName = parameterName;
    }

    public ViewSynchronizationException(String loginUrl, String returnUrl, String parameterName, String message) {

        this.loginUrl = loginUrl;
        this.returnUrl = returnUrl;
        this.parameterName = parameterName;
        this.message = message;
    }

    public String getReturnUrl() {

        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {

        this.returnUrl = returnUrl;
    }

    public String getLoginUrl() {

        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {

        this.loginUrl = loginUrl;
    }

    public String getParameterName() {

        return parameterName;
    }

    public void setParameterName(String parameterName) {

        this.parameterName = parameterName;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
