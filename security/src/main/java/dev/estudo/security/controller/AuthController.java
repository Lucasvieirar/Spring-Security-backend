package dev.estudo.security.controller;

import dev.estudo.security.Respository.UserRepository;
import dev.estudo.security.dto.request.LoginRequest;
import dev.estudo.security.dto.request.RegisterUserRequest;
import dev.estudo.security.dto.response.LoginResponse;
import dev.estudo.security.dto.response.RegisterUserResponse;
import dev.estudo.security.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;


    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return null;
    }

    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        User newUser = new User();
        newUser.setPassword(request.password());
        newUser.setEmail(request.email());
        newUser.setEmail(request.name());

        userRepository.save(newUser);

        return  ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
