package com.pragma.powerup.usermicroservice.domain.usecase;

import static org.mockito.Mockito.*;

import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserUseCaseTest {

    private IUserPersistencePort mockPersistencePort;
    private UserUseCase userUseCase;

    @BeforeEach
    public void setup() {
        mockPersistencePort = mock(IUserPersistencePort.class);
        userUseCase = new UserUseCase(mockPersistencePort);
    }

    @Test
    void testSaveOwner() {
        User user = new User(1L, "John", "Doe", "john.doe@example.com", "555-1234", "12345678A", "password", LocalDate.now());
        userUseCase.saveOwner(user);
        verify(mockPersistencePort, times(1)).saveOwner(user);
    }
}
