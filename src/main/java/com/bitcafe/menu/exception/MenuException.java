package com.bitcafe.menu.exception;

import com.bitcafe.global.exception.exception.BaseException;
import lombok.Getter;

@Getter
public class MenuException extends BaseException {
    private final MenuErrorCode errorCode;
    private final String description;

    public MenuException(MenuErrorCode errorCode) {
        this.errorCode = errorCode;
        this.description = errorCode.getDescription();
    }
}
