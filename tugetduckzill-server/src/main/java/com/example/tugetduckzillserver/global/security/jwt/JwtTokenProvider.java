package com.example.tugetduckzillserver.global.security.jwt;

import com.example.tugetduckzillserver.global.security.auth.AuthDetailsService;
import com.example.tugetduckzillserver.global.security.exception.ExpiredTokenException;
import com.example.tugetduckzillserver.global.security.exception.InvalidTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
// 개발자가 직접 정의한 객체 클래스 자체를 빈 등록할 때 사용
// 빈 : Spring IoC 컨테이너가 관리하는 자바 객체
@Component
public class JwtTokenProvider {

    private static final String ACCESS_TYPE = "access";

    private final AuthDetailsService authDetailsService;
    private final JwtProperties jwtProperties;

    public String generateToken(String accountId) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(accountId)
                .claim("type", ACCESS_TYPE)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExp() * 1000))
                .compact();
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(parseTokenBody(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).
                    parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

}
