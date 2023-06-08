package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.api.IRoleServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    private final IUserPersistencePort userPersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort, IUserPersistencePort userPersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }

    @Override
    public Role getUserRole(Long idUser) {
        return userPersistencePort.findUserById(idUser).getRole();
    }
}
