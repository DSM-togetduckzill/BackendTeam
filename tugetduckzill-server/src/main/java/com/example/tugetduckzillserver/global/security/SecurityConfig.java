package com.example.tugetduckzillserver.global.security;

import com.example.tugetduckzillserver.global.security.jwt.JwtTokenProvider;
import com.example.tugetduckzillserver.global.security.jwt.JwtTokenResolve;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity // 웹 보안을 활성화
/*하지만 그자체로는 유용하지 않고, 스프링 시큐리티가 WebSecurityConfigurer를 구현하거나
 컨텍스트의 WebSebSecurityConfigurerAdapter를 확장한 빈으로 설정되어 있어야 한다.*/
public class SecurityConfig {

    private final JwtTokenResolve jwtTokenResolver;
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    // 종속성 : 프로그램의 구조가 데이터의 구조에 영향을 받는 것
    // 외부 라이브러리 또는 이미 정의되어 있는 객체들이 서로 종속성을 가지고 있을 경우의 빈 등록에 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors();

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()

                .anyRequest().permitAll()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, jwtTokenResolver, objectMapper));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
