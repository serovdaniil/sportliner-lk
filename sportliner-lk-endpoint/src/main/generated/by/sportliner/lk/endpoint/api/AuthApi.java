/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package by.sportliner.lk.endpoint.api;

import by.sportliner.lk.endpoint.api.AuthChangePasswordDto;
import by.sportliner.lk.endpoint.api.AuthCredentialsDto;
import by.sportliner.lk.endpoint.api.AuthResponseDto;
import by.sportliner.lk.endpoint.api.AuthenticationErrorDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "auth", description = "Authentication operations")
public interface AuthApi {

    /**
     * POST /auth/login : Login into system
     *
     * @param authCredentialsDto  (required)
     * @return Authentication response (status code 200)
     *         or Invalid credentials (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "login",
        summary = "Login into system",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Authentication response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Invalid credentials", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticationErrorDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Access forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticationErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<AuthResponseDto> login(
        @Parameter(name = "AuthCredentialsDto", description = "", required = true) @Valid @RequestBody AuthCredentialsDto authCredentialsDto
    ) throws Exception;


    /**
     * POST /auth/login/changePassword : Change password
     *
     * @param authChangePasswordDto  (required)
     * @return Authentication response (status code 200)
     *         or Authentication failed (status code 401)
     *         or Authentication refused (status code 403)
     */
    @Operation(
        operationId = "loginWithChangePassword",
        summary = "Change password",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Authentication response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Authentication refused")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/login/changePassword",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<AuthResponseDto> loginWithChangePassword(
        @Parameter(name = "AuthChangePasswordDto", description = "", required = true) @Valid @RequestBody AuthChangePasswordDto authChangePasswordDto
    ) throws Exception;


    /**
     * POST /auth/logout : Logout from system
     *
     * @param automatic  (optional)
     * @return Successfully logged out (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "logout",
        summary = "Logout from system",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully logged out"),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/logout"
    )
    ResponseEntity<Void> logout(
        @Parameter(name = "automatic", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "automatic", required = false) Boolean automatic
    ) throws Exception;


    /**
     * POST /auth/refresh : Refresh auth token
     *
     * @return Response with auth tokens (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "refresh",
        summary = "Refresh auth token",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Response with auth tokens", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/refresh",
        produces = { "application/json" }
    )
    ResponseEntity<AuthResponseDto> refresh(
        
    ) throws Exception;

}
