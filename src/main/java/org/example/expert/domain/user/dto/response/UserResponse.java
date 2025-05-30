package org.example.expert.domain.user.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.entity.User;

@Getter
public class UserResponse {

    private final Long id;
    private final String email;

    /**
     * 과제 도전 5
     * 매개변수 간소화
     */
//    public UserResponse(Long id, String email) {
//        this.id = id;
//        this.email = email;
//    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }
}
