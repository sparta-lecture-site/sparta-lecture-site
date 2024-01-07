package com.sparta.lectureweb.domain.dto;

import com.sparta.lectureweb.domain.entity.Instructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstructorDto {
    private Long id;

    private int career;

    private String company;

    private String phone;

    private String instructor_intro;

    public InstructorDto(Instructor entity){
        this.id = entity.getId();
        this.career = entity.getCareer();
        this.company = entity.getCompany();
        this.phone = entity.getPhone();
        this.instructor_intro = entity.getInstructor_intro();
    }
}
