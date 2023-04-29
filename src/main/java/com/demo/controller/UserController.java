package com.demo.controller;

import static com.demo.converter.UserConverter.userDomainToResponse;
import static com.demo.converter.UserConverter.userRequestToDomain;

import com.demo.converter.UserConverter;
import com.demo.model.request.UserRequest;
import com.demo.model.response.UserResponse;
import com.demo.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        var user = userService.saveUser(userRequestToDomain(userRequest));
        return userDomainToResponse(user);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll().stream()
                .map(UserConverter::userDomainToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public Optional<UserResponse> findById(@PathVariable String userId) {
        return userService.findById(userId)
                .map(UserConverter::userDomainToResponse);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
