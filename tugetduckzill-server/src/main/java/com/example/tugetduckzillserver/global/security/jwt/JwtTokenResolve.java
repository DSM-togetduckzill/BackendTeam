package com.example.tugetduckzillserver.global.security.jwt;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtTokenResolve {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER);
        return parseToken(bearerToken);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.length() > 7 && bearerToken.startsWith(PREFIX)) {
            return bearerToken.replace(PREFIX, "");
        }
        return null;
    }
}
