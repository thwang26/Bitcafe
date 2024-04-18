package com.bitcafe.member.exception;

import com.bitcafe.global.exception.exception.BaseException;
import lombok.Getter;

@Getter
public class MemberException extends BaseException {
    private final MemberErrorCode errorCode;
    private final String description;

    public MemberException(MemberErrorCode errorCode) {
        this.errorCode = errorCode;
        this.description = errorCode.getDescription();
    }
}
