package com.testingservice.security;

import com.testingservice.models.User;
import com.testingservice.data.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsernameUniqueValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Autowired
    public UsernameUniqueValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername uniqueUsername) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isEmpty();
    }
}
