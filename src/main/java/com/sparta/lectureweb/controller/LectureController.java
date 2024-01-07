package com.sparta.lectureweb.controller;

import com.sparta.lectureweb.domain.dto.LectureDto;
import com.sparta.lectureweb.service.LectureService;
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
    public ResponseEntity<LectureDto> createLecture(LectureDto lectureDto){
        return ResponseEntity.ok(lectureService.createLecture(lectureDto));
    }

    @GetMapping("/lectures/{lectureId}")
    public ResponseEntity<LectureDto> getLecture(@PathVariable Long lectureId){
        return ResponseEntity.ok(lectureService.getLecture(lectureId));
    }

//    @GetMapping("/lecture")
//    public ResponseEntity<List<LectureDto>> getLectureListForCategory(@RequestParam String category){
//        return ResponseEntity.ok(lectureService.getLectureListForCategory(category));
//    }
}
