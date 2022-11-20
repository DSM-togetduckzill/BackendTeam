package com.example.tugetduckzillserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(max = 16)
    private String accountId;

    @NotNull
    @Length(max = 15)
    private String name;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
            "<=>?@＼^_`{|}~]{8,30}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;

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
