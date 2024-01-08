package com.sparta.lectureweb.repository;

import com.sparta.lectureweb.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByIdAndLectureId(Long commentsId, Long lectureId);
}
