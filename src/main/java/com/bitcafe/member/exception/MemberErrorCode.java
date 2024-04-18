package com.bitcafe.member.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode {
    NO_MEMBER("사용자가 없습니다.");
    private final String description;
}
