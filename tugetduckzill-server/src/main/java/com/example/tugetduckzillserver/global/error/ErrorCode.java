package com.example.tugetduckzillserver.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    PASSWORD_MISMATCH(401, "Password MisMatch"),
    INVALID_TOKEN(401, "Invalid Token"), // 유효하지 않은 토큰
    EXPIRED_TOKEN(401, "Expired Token"), // 만료된 코드

    USER_NOT_FOUND(404, "User Not Found"), // 찾을 수 없는 유저

    USER_EXISTS(409, "User Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"); // 인터넷 서버 에러

    private final int statusCode;
    private final String message;
}
