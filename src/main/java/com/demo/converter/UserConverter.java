package com.demo.converter;

import com.demo.model.domain.User;
import com.demo.model.request.UserRequest;
import com.demo.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User userRequestToDomain(UserRequest userRequest) {
        return User.builder()
                .email(userRequest.getEmail())
                .birthDate(userRequest.getBirthDate())
                .gender(userRequest.getGender())
                .name(userRequest.getName())
                .build();
    }

    public static UserResponse userDomainToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .name(user.getName())
                .build();
    }
}
