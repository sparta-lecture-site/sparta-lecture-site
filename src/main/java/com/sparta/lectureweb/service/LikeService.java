package com.sparta.lectureweb.service;

import com.sparta.lectureweb.domain.entity.Lecture;
import com.sparta.lectureweb.domain.entity.Like;
import com.sparta.lectureweb.domain.entity.User;
import com.sparta.lectureweb.message.ErrorMessage;
import com.sparta.lectureweb.repository.LectureRepository;
import com.sparta.lectureweb.repository.LikeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public void toggleLike(HttpServletRequest request, Long lectureId) {
        User user = (User)request.getAttribute("user");

        Like checkLike = likeRepository.findByUserIdAndLectureId(user.getId(), lectureId);
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage()));

        if(checkLike == null) {
            Like like = Like.builder()
                    .user(user)
                    .lecture(lecture)
                    .build();
            likeRepository.save(like);
            lecture.addLike(lecture);
        } else {
            likeRepository.delete(checkLike);
            lecture.cancelLike(lecture);
        }
    }
}
