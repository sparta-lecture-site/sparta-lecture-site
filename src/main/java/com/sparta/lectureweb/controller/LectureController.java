package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.LectureDto;
import com.sparta.lectureweb.service.LectureService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/lectures")
    public ResponseEntity<LectureDto> createLecture(@RequestBody LectureDto lectureDto, HttpServletRequest request){
        return ResponseEntity.ok(lectureService.createLecture(lectureDto, request));
    }

    @GetMapping("/lectures/{lectureId}")
    public ResponseEntity<LectureDto> getLecture(@PathVariable Long lectureId){
        return ResponseEntity.ok(lectureService.getLecture(lectureId));
    }

    @GetMapping("/lectures")
    public ResponseEntity<List<LectureDto>> getLectureListByCategory(@RequestParam String category, @RequestParam String sortBy, @RequestParam boolean direction){
        return ResponseEntity.ok(lectureService.getLectureListForCategory(category, sortBy, direction));
    }

}
