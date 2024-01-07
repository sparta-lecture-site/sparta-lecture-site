package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.Authority;
import com.sparta.lectureweb.domain.dto.LectureDto;
import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.message.ErrorMessage;
import com.sparta.lectureweb.repository.LectureRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    @Transactional
    public LectureDto createLecture(LectureDto lectureDto, HttpServletRequest request) {

        User user = (User) request.getAttribute("user");
        if(user.getAuthority() != Authority.ADMIN){
            throw new IllegalArgumentException(ErrorMessage.AUTH_EXCEPTION_MESSAGE.getErrorMessage());
        }

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


    public List<LectureDto> getLectureListForCategory(String category, String sortBy, boolean direction) {
        List<Lecture> lectureList = switch (sortBy) {
            case "lectureName" -> direction ? lectureRepository.findAllByCategoryOrderByLectureNameAsc(category) :
                    lectureRepository.findAllByCategoryOrderByLectureNameDesc(category);
            case "price" -> direction ? lectureRepository.findAllByCategoryOrderByPriceAsc(category) :
                    lectureRepository.findAllByCategoryOrderByPriceDesc(category);
            case "registerAt" -> direction ? lectureRepository.findAllByCategoryOrderByRegisterAtAsc(category) :
                    lectureRepository.findAllByCategoryOrderByRegisterAtDesc(category);
            default -> throw new IllegalArgumentException(ErrorMessage.EXIST_CATEGORY_ERROR_MESSAGE.getErrorMessage());
        };

        return lectureList.stream().map(LectureDto::new).toList();
    }
}
