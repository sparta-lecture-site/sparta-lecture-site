package com.sparta.lectureweb.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "instructor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "instructor_id")
    private Long id;

    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "career")
    private Integer career;

    @Column(name = "company")
    private String company;

    @Column(name = "phone")
    private String phone;

    @Column(name = "instructor_intro")
    private String instructorIntro;
}
