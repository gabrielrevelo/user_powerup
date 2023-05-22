package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    private final IUserRepository userRepository;

    @Override
    public void saveOwner(UserRequestDto userRequestDto) {
        User ownerUser = userRequestMapper.toUser(userRequestDto);
        Role ownerRole = new Role();
        ownerRole.setId(OWNER_ROLE_ID);
        ownerUser.setRole(ownerRole);
        userServicePort.saveUser(ownerUser);
    }

    @Override
    public String getUserRole(String userId) {
        Optional<UserEntity> userOptional = userRepository.findById(Long.valueOf(userId));
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException();
        }
        UserEntity user = userOptional.get();
        RoleEntity role = user.getRole();
        return role.getName();
    }
}
