package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/lectures/{lectureId}/comments")
    public ResponseEntity<Void> createComment(@RequestBody CommentDto requestDto, @PathVariable Long lectureId, HttpServletRequest request) {
        commentService.createComment(requestDto, lectureId, request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
