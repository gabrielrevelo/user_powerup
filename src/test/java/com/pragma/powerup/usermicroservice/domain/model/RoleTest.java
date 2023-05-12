package com.pragma.powerup.usermicroservice.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void testGettersAndSetters() {
        // Crear instancia de Role
        Role role = new Role();

        // Establecer valores de prueba
        Long id = 1L;
        role.setId(id);
        String name = "ADMIN";
        role.setName(name);
        String description = "Administrator role";
        role.setDescription(description);

        // Verificar los valores obtenidos con los getters
        assertEquals(id, role.getId());
        assertEquals(name, role.getName());
        assertEquals(description, role.getDescription());
    }

    @Test
    void testConstructorWithParameters() {
        Role role = new Role(2L, "ROLE_OWNER", "ROLE_OWNER");

        // Verificar los valores establecidos en el constructor
        assertEquals(2L, role.getId());
        assertEquals("ROLE_OWNER", role.getName());
        assertEquals("ROLE_OWNER", role.getDescription());
    }
}
