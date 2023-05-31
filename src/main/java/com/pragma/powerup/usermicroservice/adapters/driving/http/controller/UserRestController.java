package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;

    @Operation(summary = "Add a new Owner",
            responses = {
                @ApiResponse(responseCode = "201", description = "Owner created",
                        content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                @ApiResponse(responseCode = "400", description = "Owner not created",
                        content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                @ApiResponse(responseCode = "409", description = "Owner already exists",
                        content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/owner")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<Map<String, String>> saveOwner(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveOwner(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.OWNER_CREATED_MESSAGE));
    }

    @Operation(summary = "Add a new Employee",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Employee created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "400", description = "Employee not created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Employee already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/employee")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<Map<String, String>> saveEmployee(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveEmployee(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.EMPLOYEE_CREATED_MESSAGE));
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
    public ResponseEntity<Map<String, String>> saveClient(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveClient(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CLIENT_CREATED_MESSAGE));
    }
}
