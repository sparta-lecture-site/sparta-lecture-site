package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.dto.InstructorDto;
import com.sparta.lectureweb.domain.entity.Instructor;
import com.sparta.lectureweb.repository.InstructorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

        @Transactional
        public InstructorDto createInstructor(InstructorDto instructorDto){

            Instructor instructor = Instructor.builder()
                    .career(instructorDto.getCareer())
                    .company(instructorDto.getCompany())
                    .phone(instructorDto.getPhone())
                    .instructor_intro(instructorDto.getInstructor_intro())
                    .build();

            Instructor saveInstructor = instructorRepository.save(instructor);

            return new InstructorDto(saveInstructor);
        }
}
