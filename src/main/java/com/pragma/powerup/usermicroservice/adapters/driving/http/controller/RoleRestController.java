package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IRoleHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.configuration.response.CustomApiResponse;
import com.pragma.powerup.usermicroservice.configuration.response.SuccessfulApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/role")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class RoleRestController {
    private final IRoleHandler roleHandler;

    @Operation(summary = "Get all the roles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All roles returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomApiResponse.class))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomApiResponse.class)))})
    @GetMapping("")
    public ResponseEntity<SuccessfulApiResponse<List<RoleResponseDto>>> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessfulApiResponse<>(roleHandler.getAllRoles()));
    }

    @Operation(summary = "Get role name of user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Role name of user returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"error\": \"User not found\"}"))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/{id}")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<SuccessfulApiResponse<RoleResponseDto>> getUserRole(@PathVariable("id") Long idUser) {
        RoleResponseDto userRole = roleHandler.getUserRole(idUser);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessfulApiResponse<>(Constants.RESPONSE_ROLE_KEY, userRole));
    }
}
