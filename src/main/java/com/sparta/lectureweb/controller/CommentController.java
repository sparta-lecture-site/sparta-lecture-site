package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.domain.entity.Comment;
import com.sparta.lectureweb.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/lectures/{lectureId}/comments")
    public ResponseEntity<Void> createComment(@RequestBody CommentDto requestDto, @PathVariable Long lectureId, HttpServletRequest request) {
        commentService.createComment(requestDto, lectureId, request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/lectures/{lectureId}/comments/{commentsId}")
    public ResponseEntity<Void> modifyComment(@RequestBody CommentDto commentDto, @PathVariable Long lectureId, @PathVariable Long commentsId, HttpServletRequest request) {
        try {
            commentService.modifyComment(commentDto, lectureId, commentsId, request);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
