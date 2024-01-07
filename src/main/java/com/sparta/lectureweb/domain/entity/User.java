package com.sparta.lectureweb.domain.entity;

import com.sparta.lectureweb.domain.Authority;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Authority authority;
}
