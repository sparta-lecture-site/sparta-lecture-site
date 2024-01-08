package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.Authority;
import com.sparta.lectureweb.domain.dto.CommentDto;
import com.sparta.lectureweb.domain.dto.InstructorDto;
import com.sparta.lectureweb.domain.dto.LectureDto;
import com.sparta.lectureweb.domain.entity.Comment;
import com.sparta.lectureweb.domain.entity.Instructor;
import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.message.ErrorMessage;
import com.sparta.lectureweb.repository.CommentRepository;
import com.sparta.lectureweb.repository.InstructorRepository;
import com.sparta.lectureweb.repository.LectureRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final InstructorRepository instructorRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public LectureDto createLecture(LectureDto lectureDto, HttpServletRequest request) {

        User user = (User) request.getAttribute("user");
        if(user.getAuthority() != Authority.ADMIN){
            throw new IllegalArgumentException(ErrorMessage.AUTH_EXCEPTION_MESSAGE.getErrorMessage());
        }

        Instructor instructor = findInstructor(lectureDto.getInstructor().getId());
        Lecture lecture = Lecture.builder()
                .lectureName(lectureDto.getLectureName())
                .price(lectureDto.getPrice())
                .lectureIntro(lectureDto.getLectureIntro())
                .category(lectureDto.getCategory())
                .likes(lectureDto.getLikes())
                .instructor(instructor)
                .build();
        Lecture savelecture = lectureRepository.save(lecture);

        return new LectureDto(savelecture);
    }

    public LectureDto getLecture(Long lectureId) {

        Lecture lecture = findLecture(lectureId);
        Instructor instructor = findInstructor(lecture.getInstructor().getId());
        List<CommentDto> commentDtoList = commentRepository.findAllByLectureId(lectureId).stream()
                                                            .map(CommentDto::new).toList();;

        InstructorDto instructorDto = InstructorDto.builder()
                .id(instructor.getId())
                .instructorName(instructor.getInstructorName())
                .career(instructor.getCareer())
                .company(instructor.getCompany())
                .instructorIntro(instructor.getInstructorIntro())
                .build();

        return new LectureDto(findLecture(lectureId), instructorDto, commentDtoList);
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

    private Lecture findLecture(Long lectureId){
        return lectureRepository.findById(lectureId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage()));
    }

    private Instructor findInstructor(Long instructorId){
        return instructorRepository.findById(instructorId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_INSTRUCTOR_ERROR_MESSAGE.getErrorMessage()));
    }
}
