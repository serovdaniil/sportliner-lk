/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package by.sportliner.lk.endpoint.api;

import by.sportliner.lk.endpoint.api.AttendanceDto;
import by.sportliner.lk.endpoint.api.ChildAttendanceDto;
import java.util.List;
import by.sportliner.lk.endpoint.api.TrialAttendanceDto;
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
@Tag(name = "attendance", description = "Attendances operations")
public interface AttendanceApi {

    /**
     * POST /trialAttendance/{trialAttendanceId}/confirmPaid : Confirm paid trial attendance
     *
     * @param trialAttendanceId  (required)
     * @return Update status trial attendance (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "confirmPaidTrialAttendance",
        summary = "Confirm paid trial attendance",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Update status trial attendance"),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/trialAttendance/{trialAttendanceId}/confirmPaid"
    )
    ResponseEntity<Void> confirmPaidTrialAttendance(
        @Parameter(name = "trialAttendanceId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("trialAttendanceId") String trialAttendanceId
    ) throws Exception;


    /**
     * POST /trialAttendance/{trialAttendanceId}/confirmAttendance : Confirm trial attendance
     *
     * @param trialAttendanceId  (required)
     * @return Update status trial attendance (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "confirmTrialAttendance",
        summary = "Confirm trial attendance",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Update status trial attendance"),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/trialAttendance/{trialAttendanceId}/confirmAttendance"
    )
    ResponseEntity<Void> confirmTrialAttendance(
        @Parameter(name = "trialAttendanceId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("trialAttendanceId") String trialAttendanceId
    ) throws Exception;


    /**
     * POST /trialAttendance : Create trial attendances
     *
     * @param trialAttendanceDto  (required)
     * @return Successfully created (status code 201)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "createTrialAttendances",
        summary = "Create trial attendances",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/trialAttendance",
        consumes = { "application/json" }
    )
    ResponseEntity<Void> createTrialAttendances(
        @Parameter(name = "TrialAttendanceDto", description = "", required = true) @Valid @RequestBody TrialAttendanceDto trialAttendanceDto
    ) throws Exception;


    /**
     * GET /branchOffices/{branchOfficeId}/attendances/{period} : Get attendances for branch office of target period
     *
     * @param branchOfficeId  (required)
     * @param period  (required)
     * @return Attendance for children (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "getAttendancesForBranchOffice",
        summary = "Get attendances for branch office of target period",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Attendance for children", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ChildAttendanceDto.class)))
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
        value = "/branchOffices/{branchOfficeId}/attendances/{period}",
        produces = { "application/json" }
    )
    ResponseEntity<List<ChildAttendanceDto>> getAttendancesForBranchOffice(
        @Parameter(name = "branchOfficeId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("branchOfficeId") String branchOfficeId,
        @Parameter(name = "period", description = "", required = true, in = ParameterIn.PATH) @PathVariable("period") java.time.YearMonth period
    ) throws Exception;


    /**
     * GET /child/{childId}/attendances : Get attendances for child
     *
     * @param childId  (required)
     * @return Attendance for children (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "getAttendancesForChild",
        summary = "Get attendances for child",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Attendance for children", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AttendanceDto.class)))
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
        value = "/child/{childId}/attendances",
        produces = { "application/json" }
    )
    ResponseEntity<List<AttendanceDto>> getAttendancesForChild(
        @Parameter(name = "childId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("childId") String childId
    ) throws Exception;


    /**
     * GET /trialAttendance : Get trial attendances
     *
     * @return Trial Attendance (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "getTrialAttendances",
        summary = "Get trial attendances",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Trial Attendance", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TrialAttendanceDto.class)))
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
        value = "/trialAttendance",
        produces = { "application/json" }
    )
    ResponseEntity<List<TrialAttendanceDto>> getTrialAttendances(
        
    ) throws Exception;


    /**
     * PUT /branchOffices/{branchOfficeId}/attendances/{period} : Save attendance
     *
     * @param branchOfficeId  (required)
     * @param period  (required)
     * @param childAttendanceDto  (required)
     * @return Successfully saved (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access forbidden (status code 403)
     */
    @Operation(
        operationId = "saveAttendances",
        summary = "Save attendance",
        tags = { "attendance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully saved"),
            @ApiResponse(responseCode = "401", description = "Not authenticated"),
            @ApiResponse(responseCode = "403", description = "Access forbidden")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/branchOffices/{branchOfficeId}/attendances/{period}",
        consumes = { "application/json" }
    )
    ResponseEntity<Void> saveAttendances(
        @Parameter(name = "branchOfficeId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("branchOfficeId") String branchOfficeId,
        @Parameter(name = "period", description = "", required = true, in = ParameterIn.PATH) @PathVariable("period") java.time.YearMonth period,
        @Parameter(name = "ChildAttendanceDto", description = "", required = true) @Valid @RequestBody List<ChildAttendanceDto> childAttendanceDto
    ) throws Exception;

}
