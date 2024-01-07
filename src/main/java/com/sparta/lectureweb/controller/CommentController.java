package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/lecture/{lectureId}/comments")
    public ResponseEntity<Void> createComment(@RequestBody CommentDto requestDto, @PathVariable Long lectureId) {
        commentService.createComment(requestDto,lectureId);
    }
}
