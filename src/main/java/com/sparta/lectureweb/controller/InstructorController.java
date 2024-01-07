package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.InstructorDto;
import com.sparta.lectureweb.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    public ResponseEntity<InstructorDto> createInstrucor(InstructorDto instructorDto){
        instructorDto = instructorService.createInstructor(instructorDto);
        return ResponseEntity.ok(instructorDto);
    }
}