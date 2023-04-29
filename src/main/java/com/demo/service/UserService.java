package com.demo.service;

import com.demo.model.domain.User;
import com.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }


}
