package com.sros.cardmanagement.dto;

public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
