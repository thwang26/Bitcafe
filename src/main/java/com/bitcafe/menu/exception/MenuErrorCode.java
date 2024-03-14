package com.bitcafe.menu.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuErrorCode {
    NO_MENU("메뉴가 없습니다.");
    private final String description;
}
