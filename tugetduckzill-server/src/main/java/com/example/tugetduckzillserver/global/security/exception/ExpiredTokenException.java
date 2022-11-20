package com.example.tugetduckzillserver.global.security.exception;


import com.example.tugetduckzillserver.global.error.CustomException;
import com.example.tugetduckzillserver.global.error.ErrorCode;

public class ExpiredTokenException extends CustomException {

    public static final CustomException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    } // 만료된 토큰
}
