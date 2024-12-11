/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nttdata.microservice_card.api;

import com.nttdata.microservice_card.model.CardOperationRequest;
import com.nttdata.microservice_card.model.CardOperationResponse;
import com.nttdata.microservice_card.model.CardRequest;
import com.nttdata.microservice_card.model.CardResponse;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T01:56:00.145108700-05:00[America/Lima]")
@Validated
@Api(value = "cards", description = "the cards API")
public interface CardsApi {

    default CardsApiDelegate getDelegate() {
        return new CardsApiDelegate() {};
    }

    /**
     * POST /cards : Create a new card
     *
     * @param cardRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     */
    @ApiOperation(value = "Create a new card", nickname = "createCard", notes = "", response = CardResponse.class, tags={ "card", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Card created", response = CardResponse.class),
        @ApiResponse(code = 400, message = "Invalid input") })
    @PostMapping(
        value = "/cards",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<CardResponse> createCard(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CardRequest cardRequest) {
        return getDelegate().createCard(cardRequest);
    }


    /**
     * DELETE /cards/{cardNumber} : Delete a card by card number
     *
     * @param cardNumber  (required)
     * @return No content (status code 204)
     *         or Invalid body supplied (status code 400)
     *         or Client not found (status code 404)
     */
    @ApiOperation(value = "Delete a card by card number", nickname = "deleteCardByCardNumber", notes = "", tags={ "card", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Invalid body supplied"),
        @ApiResponse(code = 404, message = "Client not found") })
    @DeleteMapping(
        value = "/cards/{cardNumber}"
    )
    default ResponseEntity<Void> deleteCardByCardNumber(@ApiParam(value = "",required=true) @PathVariable("cardNumber") String cardNumber) {
        return getDelegate().deleteCardByCardNumber(cardNumber);
    }


    /**
     * GET /cards : Get all cards
     *
     * @return Successful Operation (status code 200)
     */
    @ApiOperation(value = "Get all cards", nickname = "getCards", notes = "", response = CardResponse.class, responseContainer = "List", tags={ "card", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = CardResponse.class, responseContainer = "List") })
    @GetMapping(
        value = "/cards",
        produces = { "application/json" }
    )
    default ResponseEntity<List<CardResponse>> getCards() {
        return getDelegate().getCards();
    }


    /**
     * POST /cards/payment : Pay amount with card
     *
     * @param cardOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     */
    @ApiOperation(value = "Pay amount with card", nickname = "payment", notes = "", response = CardOperationResponse.class, tags={ "card", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Card created", response = CardOperationResponse.class),
        @ApiResponse(code = 400, message = "Invalid input") })
    @PostMapping(
        value = "/cards/payment",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<CardOperationResponse> payment(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CardOperationRequest cardOperationRequest) {
        return getDelegate().payment(cardOperationRequest);
    }


    /**
     * POST /cards/withdraw : Withdraw amount with card
     *
     * @param cardOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     */
    @ApiOperation(value = "Withdraw amount with card", nickname = "withdraw", notes = "", response = CardOperationResponse.class, tags={ "card", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Card created", response = CardOperationResponse.class),
        @ApiResponse(code = 400, message = "Invalid input") })
    @PostMapping(
        value = "/cards/withdraw",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<CardOperationResponse> withdraw(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CardOperationRequest cardOperationRequest) {
        return getDelegate().withdraw(cardOperationRequest);
    }

}
