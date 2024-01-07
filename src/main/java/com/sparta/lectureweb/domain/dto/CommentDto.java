package com.sparta.lectureweb.domain.dto;

import com.sparta.lectureweb.domain.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String contents;
    private Long userId;
    private Long lectureId;

    public CommentDto(Comment entity) {
        this.id = entity.getId();
        this.contents = entity.getContents();
        this.userId = entity.getUser().getId();
        this.lectureId = entity.getLecture().getId();
    }
}
