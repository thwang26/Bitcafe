package com.bitcafe.cart.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CartErrorCode {
//    NO_MENU("메뉴가 없습니다.");
    ;
    private final String description;
}
