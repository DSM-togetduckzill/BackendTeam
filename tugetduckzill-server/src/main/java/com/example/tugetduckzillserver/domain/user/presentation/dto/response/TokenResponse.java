package com.example.tugetduckzillserver.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private final String accessToken;
}