package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.UserDto;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.repository.CommentRepository;
import com.sparta.lectureweb.repository.LikeRepository;
import com.sparta.lectureweb.repository.UserRepository;
import com.sparta.lectureweb.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Validated
public class UserService {

    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final JwtUtil jwtUtil;

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

    public void login(UserDto requestDto, HttpServletResponse response) {

        User user = userRepository.findByEmail(requestDto.getEmail()).orElseThrow();

        if (!user.getPassword().equals(requestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.createToken(user.getEmail(), user.getAuthority());
        jwtUtil.addJwtToCookie(token, response);
    }

    public void deleteUser(Long userId) {
        likeRepository.deleteAllInBatch(likeRepository.findByUserId(userId));
        commentRepository.deleteAllInBatch(commentRepository.findByUserId(userId));
        userRepository.deleteById(userId);
    }
}
