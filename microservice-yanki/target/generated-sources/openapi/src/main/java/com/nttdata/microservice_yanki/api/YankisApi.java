/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nttdata.microservice_yanki.api;

import com.nttdata.microservice_yanki.model.YankiOperationRequest;
import com.nttdata.microservice_yanki.model.YankiOperationResponse;
import com.nttdata.microservice_yanki.model.YankiRequest;
import com.nttdata.microservice_yanki.model.YankiResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-03T00:14:07.835996300-05:00[America/Lima]")
@Validated
@Api(value = "yankis", description = "the yankis API")
public interface YankisApi {

    default YankisApiDelegate getDelegate() {
        return new YankisApiDelegate() {};
    }

    /**
     * POST /yankis : Create a new yanki account
     *
     * @param yankiRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     */
    @ApiOperation(value = "Create a new yanki account", nickname = "createYanki", notes = "", response = YankiResponse.class, tags={ "yanki", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Card created", response = YankiResponse.class),
        @ApiResponse(code = 400, message = "Invalid input") })
    @PostMapping(
        value = "/yankis",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<YankiResponse> createYanki(@ApiParam(value = "" ,required=true )  @Valid @RequestBody YankiRequest yankiRequest) {
        return getDelegate().createYanki(yankiRequest);
    }


    /**
     * DELETE /yankis/{identifierValue} : Delete a yanki account by identifier
     *
     * @param identifierValue  (required)
     * @return No content (status code 204)
     *         or Invalid body supplied (status code 400)
     *         or Client not found (status code 404)
     */
    @ApiOperation(value = "Delete a yanki account by identifier", nickname = "deleteYankiByIdentifier", notes = "", tags={ "yanki", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Invalid body supplied"),
        @ApiResponse(code = 404, message = "Client not found") })
    @DeleteMapping(
        value = "/yankis/{identifierValue}"
    )
    default ResponseEntity<Void> deleteYankiByIdentifier(@ApiParam(value = "",required=true) @PathVariable("identifierValue") String identifierValue) {
        return getDelegate().deleteYankiByIdentifier(identifierValue);
    }


    /**
     * GET /yankis : Get all yanki accounts
     *
     * @return Successful Operation (status code 200)
     */
    @ApiOperation(value = "Get all yanki accounts", nickname = "getYankis", notes = "", response = YankiResponse.class, responseContainer = "List", tags={ "yanki", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = YankiResponse.class, responseContainer = "List") })
    @GetMapping(
        value = "/yankis",
        produces = { "application/json" }
    )
    default ResponseEntity<List<YankiResponse>> getYankis() {
        return getDelegate().getYankis();
    }


    /**
     * POST /yankis/payment : Pay amount with yanki
     *
     * @param yankiOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     */
    @ApiOperation(value = "Pay amount with yanki", nickname = "payment", notes = "", response = YankiOperationResponse.class, tags={ "yanki", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Card created", response = YankiOperationResponse.class),
        @ApiResponse(code = 400, message = "Invalid input") })
    @PostMapping(
        value = "/yankis/payment",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<YankiOperationResponse> payment(@ApiParam(value = "" ,required=true )  @Valid @RequestBody YankiOperationRequest yankiOperationRequest) {
        return getDelegate().payment(yankiOperationRequest);
    }


    /**
     * POST /yankis/withdraw : Withdraw amount with yanki
     *
     * @param yankiOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     */
    @ApiOperation(value = "Withdraw amount with yanki", nickname = "withdraw", notes = "", response = YankiOperationResponse.class, tags={ "yanki", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Card created", response = YankiOperationResponse.class),
        @ApiResponse(code = 400, message = "Invalid input") })
    @PostMapping(
        value = "/yankis/withdraw",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<YankiOperationResponse> withdraw(@ApiParam(value = "" ,required=true )  @Valid @RequestBody YankiOperationRequest yankiOperationRequest) {
        return getDelegate().withdraw(yankiOperationRequest);
    }

}
