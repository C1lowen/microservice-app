package com.eugen.obiedkov.OrderService.external.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ErrorResponse {
    private String errorMessage;
    private HttpStatus errorCode;
}
