package com.example.tugetduckzillserver.domain.user.service;

import com.example.tugetduckzillserver.domain.user.domain.User;
import com.example.tugetduckzillserver.domain.user.domain.repository.UserRepository;
import com.example.tugetduckzillserver.domain.user.exception.UserExistsException;
import com.example.tugetduckzillserver.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(SignUpRequest request) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .introduce(request.getIntroduce())
                .birthday(request.getBirthday())
                .phoneNumber(request.getPhoneNumber())
                .profileImage(request.getProfileImage())
                .build();
        userRepository.save(user);
    }
}
