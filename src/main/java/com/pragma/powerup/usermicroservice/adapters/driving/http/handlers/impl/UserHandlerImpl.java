package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    private final IUserRepository userRepository;

    @Override
    public void saveOwner(UserRequestDto userRequestDto) {
        userServicePort.saveOwner(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public String getUserRole(String userId) {
        Optional<UserEntity> userOptional = userRepository.findById(Long.valueOf(userId));

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            RoleEntity role = user.getRole();

            if (role != null) {
                return role.getName(); // Devuelve el nombre del rol
            }
        }

        return null; // Si no se encuentra el usuario o no tiene un rol asignado, devuelve null
    }
}
