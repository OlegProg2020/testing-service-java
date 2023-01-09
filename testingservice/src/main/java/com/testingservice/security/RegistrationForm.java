package com.testingservice.security;

import com.testingservice.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationForm {
    @Size(min = 4, max = 100, message = "username must contain from 4 to 100 characters")
    @NotBlank(message = "username can't be blank")
    @UniqueUsername(message = "this username is already in use")
    private String username;

    @NotBlank(message = "password can't be blank")
    @Size(min = 4, max = 100, message = "password must contain from 4 to 100 characters")
    private String password;

    public RegistrationForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password));
    }
}
