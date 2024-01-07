package com.sparta.lectureweb.repository;

import com.sparta.lectureweb.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllByCategoryOrderByLectureNameAsc(String category);
    List<Lecture> findAllByCategoryOrderByLectureNameDesc(String category);
    List<Lecture> findAllByCategoryOrderByPriceAsc(String category);
    List<Lecture> findAllByCategoryOrderByPriceDesc(String category);
    List<Lecture> findAllByCategoryOrderByRegisterAtAsc(String category);
    List<Lecture> findAllByCategoryOrderByRegisterAtDesc(String category);

}
