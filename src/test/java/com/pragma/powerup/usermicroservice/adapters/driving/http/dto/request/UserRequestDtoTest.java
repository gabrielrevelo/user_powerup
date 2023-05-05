package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.UserUnderAgeException;
import jakarta.validation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

class UserRequestDtoTest {

    @Test
    void testGetters() {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName("John");
        userRequestDto.setSurname("Doe");
        userRequestDto.setMail("john.doe@example.com");
        userRequestDto.setPhone("123456789");
        userRequestDto.setDniNumber("12345678A");
        userRequestDto.setPassword("password123");
        userRequestDto.setDateOfBirth("2000-01-01");

        Assertions.assertEquals("John", userRequestDto.getName());
        Assertions.assertEquals("Doe", userRequestDto.getSurname());
        Assertions.assertEquals("john.doe@example.com", userRequestDto.getMail());
        Assertions.assertEquals("123456789", userRequestDto.getPhone());
        Assertions.assertEquals("12345678A", userRequestDto.getDniNumber());
        Assertions.assertEquals("password123", userRequestDto.getPassword());
        Assertions.assertEquals("2000-01-01", userRequestDto.getDateOfBirth());
    }

    @Test
    void testEmptyName() {
        UserRequestDto dto = new UserRequestDto("", "Doe", "john.doe@example.com", "123456789", "12345678A", "password123", "2000-01-01");

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        });
    }

    @Test
    void testValidateAgeThrowsException() {
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setDateOfBirth(LocalDate.now().minusYears(17).toString());

        Assertions.assertThrows(UserUnderAgeException.class, userRequestDto::validateAge);
    }

    @Test
    void testValidateAgeDoesNotThrowException() {
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setDateOfBirth(LocalDate.now().minusYears(20).toString());

        Assertions.assertDoesNotThrow(userRequestDto::validateAge);
    }
}
