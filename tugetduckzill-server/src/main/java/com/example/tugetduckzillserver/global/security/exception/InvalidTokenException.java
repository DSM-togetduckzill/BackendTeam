package com.example.tugetduckzillserver.global.security.exception;


import com.example.tugetduckzillserver.global.error.CustomException;
import com.example.tugetduckzillserver.global.error.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    } // 유효하지 않은 토큰
}
