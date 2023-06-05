package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;

public interface IUserHandler {
    void saveOwner(UserRequestDto personRequestDto);

    UserResponseDto saveEmployee(UserRequestDto userRequestDto);

    void saveClient(UserRequestDto userRequestDto);
}
