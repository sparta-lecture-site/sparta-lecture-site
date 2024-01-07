package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.UserDto;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public void createUser(@Valid UserDto requestDto) {

        User user = User.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .gender(requestDto.getGender())
                .phone(requestDto.getPhone())
                .address(requestDto.getAddress())
                .authority(requestDto.getAuthority())
                .build();

        userRepository.save(user);
    }
}
