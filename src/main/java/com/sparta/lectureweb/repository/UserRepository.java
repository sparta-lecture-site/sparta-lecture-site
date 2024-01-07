package com.sparta.lectureweb.repository;

import com.sparta.lectureweb.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
