package com.example.tugetduckzillserver.domain.user.exception;

import com.example.tugetduckzillserver.global.error.CustomException;
import com.example.tugetduckzillserver.global.error.ErrorCode;

public class UserExistsException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.USER_EXISTS);
    }
}