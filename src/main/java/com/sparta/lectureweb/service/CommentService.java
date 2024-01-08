package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.domain.entity.Comment;
import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.repository.CommentRepository;
import com.sparta.lectureweb.repository.LectureRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void modifyComment(CommentDto requestDto, Long lectureId, Long commentsId, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        Comment comment = commentRepository.findByIdAndLectureId(commentsId, lectureId);

        if (!user.getId().equals(comment.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "접근 권한이 없습니다.");
        }

        comment.setContents(requestDto.getContents());
    }
}
