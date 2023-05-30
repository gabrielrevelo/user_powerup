package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.api.IRoleServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoleUseCaseTest {

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @Mock
    private IUserPersistencePort userPersistencePort;

    private IRoleServicePort roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roleService = new RoleUseCase(rolePersistencePort, userPersistencePort);
    }

    @Test
    void testGetAllRoles() {
        // Mock data
        List<Role> roles = Arrays.asList(new Role(1L, "ROLE_ADMIN","ROLE_ADMIN"), new Role(2L, "ROLE_USER","ROLE_USER"));
        when(rolePersistencePort.getAllRoles()).thenReturn(roles);

        // Test
        List<Role> result = roleService.getAllRoles();

        // Verify
        verify(rolePersistencePort, times(1)).getAllRoles();
        assertEquals(roles, result);
    }

    @Test
    void testGetRoleName() {
        // Mock data
        Long userId = 1L;
        Role role = new Role(1L, "ROLE_ADMIN","ROLE_ADMIN");
        User user = new User();
        user.setId(userId);
        user.setRole(role);
        when(userPersistencePort.findUserById(userId)).thenReturn(user);

        // Test
        String result = roleService.getRoleName(userId);

        // Verify
        verify(userPersistencePort, times(1)).findUserById(userId);
        assertEquals(role.getName(), result);
    }
}
