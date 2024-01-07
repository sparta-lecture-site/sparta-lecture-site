package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.domain.entity.Comment;
import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(CommentDto requestDto,Long lectureId) {

        Lecture lecture =

        Comment comment = Comment.builder()
                .contents(requestDto.getContents())
                .user(requestDto.getUserId())
                .lecture(requestDto.getLectureId())
                .build();
    }
}
