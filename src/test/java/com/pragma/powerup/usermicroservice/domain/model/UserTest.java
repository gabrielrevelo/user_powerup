package com.pragma.powerup.usermicroservice.domain.model;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User(null, null, null, null, null, null, null, null, null);

        Long id = 1L;
        user.setId(id);
        String name = "Juan";
        user.setName(name);
        String surname = "Gómez";
        user.setSurname(surname);
        String mail = "juan.gomez@example.com";
        user.setMail(mail);
        String phone = "+573001234567";
        user.setPhone(phone);
        String dniNumber = "1234567890";
        user.setDniNumber(dniNumber);
        String password = "password123";
        user.setPassword(password);
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 15);
        user.setDateOfBirth(dateOfBirth);
        Role role = new Role(Constants.OWNER_ROLE_ID,"ROLE_OWNER", "ROLE_OWNER");
        user.setRole(role);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(mail, user.getMail());
        assertEquals(phone, user.getPhone());
        assertEquals(dniNumber, user.getDniNumber());
        assertEquals(password, user.getPassword());
        assertEquals(dateOfBirth, user.getDateOfBirth());
        assertEquals(role, user.getRole());
    }
}
