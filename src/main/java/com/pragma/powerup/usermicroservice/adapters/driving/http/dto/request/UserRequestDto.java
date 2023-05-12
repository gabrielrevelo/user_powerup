package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "User DTO")
public class UserRequestDto {
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Schema(description = "Name", example = "Juan")
    private String name;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Schema(description = "Surname", example = "Gomez")
    private String surname;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = Constants.INVALID_FORMAT_MESSAGE)
    @Schema(description = "Email", example = "juangomez@example.com")
    private String mail;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{12}$", message = Constants.INVALID_FORMAT_MESSAGE)
    @Schema(description = "Cellphone Number", example = "+573001234567")
    private String phone;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^\\d{6,10}$", message = Constants.INVALID_FORMAT_MESSAGE)
    @Schema(description = "Identification Document Number", example = "1234567890")
    private String dniNumber;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Schema(description = "Password", example = "Password123!")
    private String password;
    @Past(message = Constants.DATE_CANNOT_BE_PAST_MESSAGE)
    @Schema(description = "Date of Birth", example = "2000-02-20")
    private LocalDate dateOfBirth;
}
