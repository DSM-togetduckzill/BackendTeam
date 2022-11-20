package com.example.tugetduckzillserver.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MyPageResponse {

    private final String name;
    private final String introduce;
    private final LocalDate birthday;
    private final String phoneNumber;
    private final String profileImage;
}