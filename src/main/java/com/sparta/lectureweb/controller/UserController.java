package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.UserDto;
import com.sparta.lectureweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserDto requestDto) {
        userService.createUser(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
