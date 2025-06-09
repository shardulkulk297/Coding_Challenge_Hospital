package com.codingChallenge.project.service;

import com.codingChallenge.project.dto.UserDto;
import com.codingChallenge.project.model.User;
import com.codingChallenge.project.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDto signUp(User user){
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        User userSaved = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setUsername(userSaved.getUsername());
        userDto.setRole(userSaved.getRole());
        return userDto;
    }
}
