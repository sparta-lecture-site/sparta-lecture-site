package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.domain.entity.Comment;
import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.repository.CommentRepository;
import com.sparta.lectureweb.repository.LectureRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final LectureRepository lectureRepository;
    public void createComment(CommentDto requestDto, Long lectureId, HttpServletRequest request) {

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow();
        User user = (User) request.getAttribute("user");

        Comment comment = Comment.builder()
                .contents(requestDto.getContents())
                .user(user)
                .lecture(lecture)
                .build();

        commentRepository.save(comment);
    }
}
