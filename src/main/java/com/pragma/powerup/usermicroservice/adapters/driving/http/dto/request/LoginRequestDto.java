package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginRequestDto {
    @NotBlank
    @Schema(description = "Email", example = "juangomez@example.com")
    private String mail;
    @NotBlank
    @Schema(description = "Password", example = "Password123!")
    private String password;
}
