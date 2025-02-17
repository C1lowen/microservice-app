package com.eugen.obiedkov.OrderService.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private HttpStatus errorCode;
    private Integer status;

    public CustomException(String message, HttpStatus errorCode, Integer status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
