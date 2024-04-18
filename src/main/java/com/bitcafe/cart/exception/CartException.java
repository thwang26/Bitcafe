package com.bitcafe.cart.exception;

import com.bitcafe.global.exception.exception.BaseException;
import lombok.Getter;

@Getter
public class CartException extends BaseException {
    private final CartErrorCode errorCode;
    private final String description;

    public CartException(CartErrorCode errorCode) {
        this.errorCode = errorCode;
        this.description = errorCode.getDescription();
    }
}
