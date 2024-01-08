package com.sparta.lectureweb.domain.dto;

import com.sparta.lectureweb.domain.entity.Instructor;
import com.sparta.lectureweb.domain.entity.Lecture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LectureDto {

    private Long id;
    private String lectureName;
    private Integer price;
    private String lectureIntro;
    private String category;
    private Integer likes;
    private LocalDate registerAt;
    private InstructorDto instructor;

    public LectureDto(Lecture entity) {
        this.id = entity.getId();
        this.lectureName = entity.getLectureName();
        this.price = entity.getPrice();
        this.lectureIntro = entity.getLectureIntro();
        this.category = entity.getCategory();
        this.registerAt = entity.getRegisterAt();
        this.likes = entity.getLikes();
    }

    public LectureDto(Lecture entity, InstructorDto instructorDto) {
        this.id = entity.getId();
        this.lectureName = entity.getLectureName();
        this.price = entity.getPrice();
        this.lectureIntro = entity.getLectureIntro();
        this.category = entity.getCategory();
        this.registerAt = entity.getRegisterAt();
        this.likes = entity.getLikes();
        this.instructor = instructorDto;
    }
}
