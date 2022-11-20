package com.example.tugetduckzillserver.domain.user.exception;

import com.example.tugetduckzillserver.global.error.CustomException;
import com.example.tugetduckzillserver.global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final PasswordMisMatchException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
