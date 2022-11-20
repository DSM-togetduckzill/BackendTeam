package com.example.tugetduckzillserver.domain.user.presentation;

import com.example.tugetduckzillserver.domain.user.presentation.dto.request.SignInRequest;
import com.example.tugetduckzillserver.domain.user.presentation.dto.request.SignUpRequest;
import com.example.tugetduckzillserver.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.tugetduckzillserver.domain.user.presentation.dto.response.MyPageResponse;
import com.example.tugetduckzillserver.domain.user.presentation.dto.response.TokenResponse;
import com.example.tugetduckzillserver.domain.user.service.MyPageService;
import com.example.tugetduckzillserver.domain.user.service.SignInService;
import com.example.tugetduckzillserver.domain.user.service.SignUpService;
import com.example.tugetduckzillserver.domain.user.service.UpdateUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final MyPageService myPageService;
    private final UpdateUserInfoService updateUserInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return signInService.execute(request);
    }

    @GetMapping("/mypage")
    public MyPageResponse myPage() {
        return myPageService.execute();
    }

    @PatchMapping("/mypage")
    public void updateMyPage(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }
}
