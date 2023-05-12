package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.UserUnderAgeException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    private UserUseCase userUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        userUseCase = new UserUseCase(userPersistencePort);
    }

    @Test
    void testSaveUser_ThrowsUserUnderAgeException() {
        User user = new User(null, null, null, null, null, null, null, LocalDate.now().minusYears(16), null);

        assertThrows(UserUnderAgeException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void testSaveUser_Successful() {
        User user = new User(null, null, null, null, null, null, null, LocalDate.now().minusYears(20), null);

        userUseCase.saveUser(user);

        verify(userPersistencePort, times(1)).saveUser(user);
    }
}
