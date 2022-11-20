package com.example.tugetduckzillserver.domain.user.service;

import com.example.tugetduckzillserver.domain.user.domain.User;
import com.example.tugetduckzillserver.domain.user.presentation.dto.response.MyPageResponse;
import com.example.tugetduckzillserver.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final CurrentUserFacade currentUserFacade;

    public MyPageResponse execute() {
        User user = currentUserFacade.getCurrentUser();

        return MyPageResponse.builder()
                .name(user.getName())
                .introduce(user.getIntroduce())
                .birthday(user.getBirthday())
                .phoneNumber(user.getPhoneNumber())
                .profileImage(user.getProfileImage())
                .build();

//        return new MyPageResponse(user.getName(), user.getIntroduce(), user.getBirthday(), user.getPhoneNumber(), user.getProfileImage());
    }
}
