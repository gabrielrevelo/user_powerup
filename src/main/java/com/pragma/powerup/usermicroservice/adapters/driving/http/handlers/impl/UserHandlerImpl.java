package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    @Override
    public void saveOwner(UserRequestDto userRequestDto) {
        User ownerUser = userRequestMapper.toUser(userRequestDto);
        ownerUser.setRole(new Role(OWNER_ROLE_ID));
        userServicePort.saveUser(ownerUser);
    }

    @Override
    public void saveEmployee(UserRequestDto userRequestDto) {
        User employeeUser = userRequestMapper.toUser(userRequestDto);
        employeeUser.setRole(new Role(EMPLOYEE_ROLE_ID));
        userServicePort.saveUser(employeeUser);
    }

    @Override
    public void saveClient(UserRequestDto userRequestDto) {
        User clientUser = userRequestMapper.toUser(userRequestDto);
        clientUser.setRole(new Role(CLIENT_ROLE_ID));
        userServicePort.saveUser(clientUser);
    }
}
