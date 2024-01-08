package com.sparta.lectureweb.repository;

import com.sparta.lectureweb.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByIdAndLectureId(Long commentsId, Long lectureId);
    Iterable<Comment> findByUserId(Long userId);
    List<Comment> findAllByLectureId(Long lectureId);
}
