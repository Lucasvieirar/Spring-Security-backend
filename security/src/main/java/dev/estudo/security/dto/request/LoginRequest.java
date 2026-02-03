package dev.estudo.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "email não pode ser vazio") String email,
                           @NotEmpty(message = "Senha é obrigatorio") String password) {

}
