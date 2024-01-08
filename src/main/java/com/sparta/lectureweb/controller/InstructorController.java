package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.InstructorDto;
import com.sparta.lectureweb.service.InstructorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/instructors")
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto instructorDto, HttpServletRequest request){
        System.out.println(instructorDto.getInstructorName());
        return ResponseEntity.ok(instructorService.createInstructor(instructorDto, request));
    }
}
