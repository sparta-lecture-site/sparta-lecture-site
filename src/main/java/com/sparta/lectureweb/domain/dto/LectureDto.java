package com.sparta.lectureweb.domain.dto;

import com.sparta.lectureweb.domain.entity.Lecture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

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

    public LectureDto(Lecture entity) {
        this.id = entity.getId();
        this.lectureName = entity.getLectureName();
        this.price = entity.getPrice();
        this.lectureIntro = entity.getLectureIntro();
        this.category = entity.getCategory();
        this.registerAt = entity.getRegisterAt();
        this.likes = entity.getLikes();
    }

}
