package com.sparta.lectureweb.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "lecture")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lecture extends AuditingFields{

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Column(name = "lecture_name")
    private String lectureName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "lecture_intro")
    private String lectureIntro;

    @Column(name = "category")
    private String category;

    @Column(name = "likes")
    private Integer likes;

    public void addLike(Lecture lecture){
        this.likes += 1;
    }
    public void cancelLike(Lecture lecture){
        this.likes -= 1;
    }
}
