package com.bitcafe.global.exception.handler;

import com.bitcafe.global.exception.dto.ErrorResponse;
import com.bitcafe.global.exception.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> CustomExceptionHandler(BaseException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .errorCode(e.getErrorCode().name())
                        .description(e.getDescription())
                        .build());
    }
}
