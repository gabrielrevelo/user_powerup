package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.configuration.response.CustomApiResponse;
import com.pragma.powerup.usermicroservice.configuration.response.SuccessfulApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@Tag(name = "User Controller", description = "Controller for managing users")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;

    @Operation(summary = "[ADMIN] Add a new Owner",
            responses = {
                @ApiResponse(responseCode = "201", description = "Owner created",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomApiResponse.class))),
                @ApiResponse(responseCode = "400", description = "Owner not created",
                        content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                @ApiResponse(responseCode = "409", description = "Owner already exists",
                        content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/owner")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<SuccessfulApiResponse<Void>> saveOwner(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveOwner(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessfulApiResponse<>(Constants.OWNER_CREATED_MESSAGE));
    }

    @Operation(summary = "[OWNER] Add a new Employee",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Employee created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "400", description = "Employee not created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Employee already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/employee")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<SuccessfulApiResponse<UserResponseDto>> saveEmployee(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto employee = userHandler.saveEmployee(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessfulApiResponse<>(Constants.EMPLOYEE_CREATED_MESSAGE, employee));
    }

    @Operation(summary = "Add a new Client",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Client created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "400", description = "Client not created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Client already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/client")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<SuccessfulApiResponse<Void>> saveClient(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveClient(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessfulApiResponse<>(Constants.CLIENT_CREATED_MESSAGE));
    }
}
