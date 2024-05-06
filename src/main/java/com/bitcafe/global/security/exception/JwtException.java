package com.bitcafe.global.security.exception;

import com.bitcafe.global.exception.exception.BaseException;
import lombok.Getter;

@Getter
public class JwtException extends BaseException {
    private final JwtErrorCode errorCode;
    private final String description;

    public JwtException(JwtErrorCode errorCode) {
        this.errorCode = errorCode;
        this.description = errorCode.getDescription();
    }
}
