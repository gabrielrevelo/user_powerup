package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.UserUnderAgeException;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String name;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String surname;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Email(message = Constants.INVALID_FORMAT_MESSAGE)
    private String mail;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{10,12}$", message = Constants.INVALID_FORMAT_MESSAGE)
    private String phone;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "\\d*", message = Constants.INVALID_FORMAT_MESSAGE)
    private String dniNumber;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String password;
    @Past(message = Constants.DATE_CANNOT_BE_PAST_MESSAGE)
    private LocalDate dateOfBirth;
}
