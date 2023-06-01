package com.pragma.powerup.usermicroservice.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResult<T> {
    private boolean success;
    private String message;
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorDetails error;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ErrorDetails {
        private String code;
        private String message;
    }
}
