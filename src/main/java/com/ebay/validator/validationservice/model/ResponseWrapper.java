package com.ebay.validator.validationservice.model;

import org.springframework.http.HttpStatus;

public class ResponseWrapper<T> {
    public T data;
    public boolean success;
    public String message;
    public int status;

    private ResponseWrapper(T data, String message, HttpStatus status) {
        this.success = true;
        this.data = data;
        this.message = message;
        this.status = status.value();
    }

    public static <T> ResponseWrapper<T> of(T data, String msg, HttpStatus status) {
        return new ResponseWrapper<>(data, msg, status);
    }

    public static <T> ResponseWrapper<T> VALID(T data) {
        return ResponseWrapper.of(data,"item is valid", HttpStatus.OK);
    }
}
