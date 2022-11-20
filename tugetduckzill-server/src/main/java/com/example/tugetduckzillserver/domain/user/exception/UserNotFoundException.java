package com.example.tugetduckzillserver.domain.user.exception;

import com.example.tugetduckzillserver.global.error.CustomException;
import com.example.tugetduckzillserver.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
