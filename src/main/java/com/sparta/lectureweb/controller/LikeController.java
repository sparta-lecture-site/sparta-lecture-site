package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.service.LikeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/likes/{lectureId}")
    public ResponseEntity<Void> toggleLike(HttpServletRequest request, @PathVariable Long lectureId) {
        likeService.toggleLike(request, lectureId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
