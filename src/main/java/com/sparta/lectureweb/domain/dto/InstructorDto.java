package com.sparta.lectureweb.domain.dto;

import com.sparta.lectureweb.domain.entity.Instructor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InstructorDto {
    private Long id;
    private String instructorName;
    private Integer career;
    private String company;
    private String phone;
    private String instructorIntro;

    public InstructorDto(Instructor entity){
        this.id = entity.getId();
        this.instructorName = entity.getInstructorName();
        this.career = entity.getCareer();
        this.company = entity.getCompany();
        this.phone = entity.getPhone();
        this.instructorIntro = entity.getInstructorIntro();
    }
}
