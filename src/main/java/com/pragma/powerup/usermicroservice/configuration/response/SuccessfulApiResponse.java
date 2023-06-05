package com.pragma.powerup.usermicroservice.configuration.response;

public class SuccessfulApiResponse<T> extends CustomApiResponse<T> {
    public SuccessfulApiResponse(String message, T data) {
        super(true, message, data, null);
    }

    public SuccessfulApiResponse(T data) {
        super(true, null, data, null);
    }

    public SuccessfulApiResponse(String message) {
        super(true, message, null, null);
    }
}