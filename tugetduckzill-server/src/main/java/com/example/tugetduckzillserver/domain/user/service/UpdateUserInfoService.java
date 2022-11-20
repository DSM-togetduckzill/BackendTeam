package com.example.tugetduckzillserver.domain.user.service;


import com.example.tugetduckzillserver.domain.user.domain.User;
import com.example.tugetduckzillserver.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.tugetduckzillserver.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {

    private final CurrentUserFacade currentUserFacade;

    @Transactional()
    public void execute(UpdateUserInfoRequest request) {
        User user = currentUserFacade.getCurrentUser();

        user.update(request);

//         user.update(request.getName(), request.getIntroduce(), request.getBirthday(), request.getPhoneNumber(), request.getProfileImage());
    }
}