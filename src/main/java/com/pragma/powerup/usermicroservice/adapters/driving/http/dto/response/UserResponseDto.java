package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String dniNumber;
    private String dateOfBirth;
}
