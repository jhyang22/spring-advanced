package org.example.expert.domain.todo.dto.response;

import lombok.Getter;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.dto.response.UserResponse;

@Getter
public class TodoSaveResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String weather;
    private final UserResponse user;

    /**
     * 과제 도전 5
     * 매개변수 간소화
     * @param todo
     * @param user
     */
//    public TodoSaveResponse(Long id, String title, String contents, String weather, UserResponse user) {
//        this.id = id;
//        this.title = title;
//        this.contents = contents;
//        this.weather = weather;
//        this.user = user;
//    }

    public TodoSaveResponse(Todo todo, UserResponse user) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.weather = todo.getWeather();
        this.user = user;
    }
}
