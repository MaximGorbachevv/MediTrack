package com.poject2.meditrack.dto;

public class ErrorResponse {
    private String error;
    private String message;
    private java.util.Map<String, String> details;

    public ErrorResponse(String error, String message, java.util.Map<String, String> details) {
        this.error = error;
        this.message = message;
        this.details = details;
    }

    // геттеры
    public String getError() { return error; }
    public String getMessage() { return message; }
    public java.util.Map<String, String> getDetails() { return details; }
}

