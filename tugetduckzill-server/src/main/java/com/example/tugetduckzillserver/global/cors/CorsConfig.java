package com.example.tugetduckzillserver.global.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override // 부모 클래스의 메소드의 동작 방법을 재정의
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // CORS를 적용할 URL패턴을 정의
                .allowedOrigins("*") // 자원 공유를 허락할 Origin을 지정
                .allowedMethods("*") // 허용할 HTTP method를 지정
                .allowedHeaders("*"); // 어떤 Header를 허용할건지
    }
}
