package org.example.expert.domain.todo.dto.response;

import lombok.Getter;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.dto.response.UserResponse;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String weather;
    private final UserResponse user;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    /**
     * 과제 도전 5
     * 매개변수 간소화
     * @param todo
     * @param user
     */
//    public TodoResponse(Long id, String title, String contents, String weather, UserResponse user, LocalDateTime createdAt, LocalDateTime modifiedAt) {
//        this.id = id;
//        this.title = title;
//        this.contents = contents;
//        this.weather = weather;
//        this.user = user;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
//    }

    public TodoResponse(Todo todo, UserResponse user) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.weather = todo.getWeather();
        this.user = user;
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
