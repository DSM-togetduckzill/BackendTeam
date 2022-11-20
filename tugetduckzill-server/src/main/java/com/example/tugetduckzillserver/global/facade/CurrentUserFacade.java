package com.example.tugetduckzillserver.global.facade;

import com.example.tugetduckzillserver.domain.user.domain.User;
import com.example.tugetduckzillserver.domain.user.domain.repository.UserRepository;
import com.example.tugetduckzillserver.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CurrentUserFacade {

    private final UserRepository userRepository;

    public String getCurrentUserAccountId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getCurrentUser() {
        return userRepository.findByAccountId(getCurrentUserAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
