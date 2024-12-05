package com.nttdata.microservice_card.api;

import com.nttdata.microservice_card.model.CardOperationRequest;
import com.nttdata.microservice_card.model.CardOperationResponse;
import com.nttdata.microservice_card.model.CardRequest;
import com.nttdata.microservice_card.model.CardResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CardsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T01:56:00.145108700-05:00[America/Lima]")
public interface CardsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /cards : Create a new card
     *
     * @param cardRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     * @see CardsApi#createCard
     */
    default ResponseEntity<CardResponse> createCard(CardRequest cardRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"expiryDate\" : \"2000-01-23\", \"cvv\" : 956, \"cardHolder\" : \"juan sanchez\", \"accounts\" : [ \"[123456789,123456789]\", \"[123456789,123456789]\" ], \"cardNumber\" : \"2190382193217231\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /cards/{cardNumber} : Delete a card by card number
     *
     * @param cardNumber  (required)
     * @return No content (status code 204)
     *         or Invalid body supplied (status code 400)
     *         or Client not found (status code 404)
     * @see CardsApi#deleteCardByCardNumber
     */
    default ResponseEntity<Void> deleteCardByCardNumber(String cardNumber) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cards : Get all cards
     *
     * @return Successful Operation (status code 200)
     * @see CardsApi#getCards
     */
    default ResponseEntity<List<CardResponse>> getCards() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"expiryDate\" : \"2000-01-23\", \"cvv\" : 956, \"cardHolder\" : \"juan sanchez\", \"accounts\" : [ \"[123456789,123456789]\", \"[123456789,123456789]\" ], \"cardNumber\" : \"2190382193217231\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /cards/payment : Pay amount with card
     *
     * @param cardOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     * @see CardsApi#payment
     */
    default ResponseEntity<CardOperationResponse> payment(CardOperationRequest cardOperationRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"description\" : \"La operacion se realizo adecuadamente\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /cards/withdraw : Withdraw amount with card
     *
     * @param cardOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     * @see CardsApi#withdraw
     */
    default ResponseEntity<CardOperationResponse> withdraw(CardOperationRequest cardOperationRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"description\" : \"La operacion se realizo adecuadamente\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
