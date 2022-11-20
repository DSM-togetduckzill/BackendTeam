package com.example.tugetduckzillserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotNull
    @Length(max = 15)
    private String name;

    @NotNull
    @Size(max = 255)
    private String introduce;

    @NotNull
    private LocalDate birthday;

    @NotBlank
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @NotBlank
    private String profileImage;
}
