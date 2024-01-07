package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.LectureDto;
import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.message.ErrorMessage;
import com.sparta.lectureweb.repository.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    @Transactional
    public LectureDto createLecture(LectureDto lectureDto) {
        Lecture lecture = Lecture.builder()
                .lectureName(lectureDto.getLectureName())
                .price(lectureDto.getPrice())
                .lectureIntro(lectureDto.getLectureIntro())
                .category(lectureDto.getCategory())
                .build();
        Lecture savelecture = lectureRepository.save(lecture);

        return new LectureDto(savelecture);
    }

    public LectureDto getLecture(Long lectureId) {
        return new LectureDto(findLecture(lectureId));
    }

    private Lecture findLecture(Long lectureId){
        return lectureRepository.findById(lectureId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage()));
    }


}
