/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package by.sportliner.lk.endpoint.api;

import by.sportliner.lk.endpoint.api.TelegramBotApplicationDto;
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
@Tag(name = "telegram", description = "Telegram operations")
public interface TelegramApi {

    /**
     * GET /telegram/application/{telegramBotApplicationId} : Get application from telegram bot by ID
     *
     * @param telegramBotApplicationId  (required)
     * @return Telegram bot application (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "getTelegramApplicationById",
        summary = "Get application from telegram bot by ID",
        tags = { "telegram" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Telegram bot application", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TelegramBotApplicationDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/telegram/application/{telegramBotApplicationId}",
        produces = { "application/json" }
    )
    ResponseEntity<TelegramBotApplicationDto> getTelegramApplicationById(
        @Parameter(name = "telegramBotApplicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("telegramBotApplicationId") String telegramBotApplicationId
    ) throws Exception;


    /**
     * GET /telegram/application : Get applications from telegram bot
     *
     * @return Telegram bot applications (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "getTelegramApplications",
        summary = "Get applications from telegram bot",
        tags = { "telegram" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Telegram bot applications", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TelegramBotApplicationDto.class)))
            }),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/telegram/application",
        produces = { "application/json" }
    )
    ResponseEntity<List<TelegramBotApplicationDto>> getTelegramApplications(
        
    ) throws Exception;

}