package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.UserDto;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody UserDto requestDto) {
        userService.createUser(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> login(@RequestBody UserDto requestDto, HttpServletResponse response) {
        userService.login(requestDto, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public void deleteUser(HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        userService.deleteUser(user.getId());
    }
}
