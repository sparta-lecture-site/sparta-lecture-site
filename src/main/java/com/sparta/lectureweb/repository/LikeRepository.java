package com.sparta.lectureweb.repository;

import com.sparta.lectureweb.domain.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    Like findByUserIdAndLectureId(Long lectureId, Long userId);
}
