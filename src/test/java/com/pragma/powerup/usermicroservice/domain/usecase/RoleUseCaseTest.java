package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoleUseCaseTest {

    @Test
    void testGetAllRoles() {
        IRolePersistencePort rolePersistencePort = Mockito.mock(IRolePersistencePort.class);

        RoleUseCase roleUseCase = new RoleUseCase(rolePersistencePort);

        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(1L, "ROLE_ADMIN", "ROLE_ADMIN"));
        roleList.add(new Role(2L, "ROLE_OWNER", "ROLE_OWNER"));

        when(rolePersistencePort.getAllRoles()).thenReturn(roleList);

        List<Role> result = roleUseCase.getAllRoles();
        assertEquals(roleList, result);

        verify(rolePersistencePort, times(1)).getAllRoles();
    }
}
