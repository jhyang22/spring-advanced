package org.example.expert.domain.comment.dto.response;

import lombok.Getter;
import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.user.dto.response.UserResponse;

@Getter
public class CommentSaveResponse {

    private final Long id;
    private final String contents;
    private final UserResponse user;

    /**
     * 과제 도전 5
     * 매개변수 간소화
     * @param comment
     * @param user
     */
//    public CommentSaveResponse(Long id, String contents, UserResponse user) {
//        this.id = id;
//        this.contents = contents;
//        this.user = user;
//    }

    public CommentSaveResponse(Comment comment, UserResponse user) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.user = user;
    }
}
