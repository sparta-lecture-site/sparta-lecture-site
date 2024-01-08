package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.Authority;
import com.sparta.lectureweb.domain.dto.InstructorDto;
import com.sparta.lectureweb.domain.entity.Instructor;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.message.ErrorMessage;
import com.sparta.lectureweb.repository.InstructorRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

        @Transactional
        public InstructorDto createInstructor(InstructorDto instructorDto, HttpServletRequest request){
            User user = (User) request.getAttribute("user");
            if(user.getAuthority() != Authority.ADMIN){
                throw new IllegalArgumentException(ErrorMessage.AUTH_EXCEPTION_MESSAGE.getErrorMessage());
            }

            Instructor instructor = Instructor.builder()
                    .instructorName(instructorDto.getInstructorName())
                    .career(instructorDto.getCareer())
                    .company(instructorDto.getCompany())
                    .phone(instructorDto.getPhone())
                    .instructorIntro(instructorDto.getInstructorIntro())
                    .build();

            Instructor saveInstructor = instructorRepository.save(instructor);
            return new InstructorDto(saveInstructor);
        }
}
