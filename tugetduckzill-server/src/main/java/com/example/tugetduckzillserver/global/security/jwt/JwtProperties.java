package com.example.tugetduckzillserver.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding // 생성자 파라미터 바인딩
/*  Spring Boot 에서 properties 파일에 정의된 프로퍼티 중 주어진 prefix 를 가지는 프로퍼티들을
  POJO 에 매핑하여 Bean 으로 만들수 있게 해주는 어노테이션*/
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties { // Properties : 속성

    private final String SecretKey;
    private final Long accessExp;

    public JwtProperties(String secretKey, Long accessExp) {
        // 비밀 키를 문자열로 또는 그 반대로 변환
        this.SecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.accessExp = accessExp;
    }
}
