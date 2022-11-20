package com.example.tugetduckzillserver.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 혹은 @NotNull이 붙은 필드의 생성자를 자동 생성
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;
}
