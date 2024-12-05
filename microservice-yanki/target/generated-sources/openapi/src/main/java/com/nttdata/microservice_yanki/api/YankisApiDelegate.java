package com.nttdata.microservice_yanki.api;

import com.nttdata.microservice_yanki.model.YankiOperationRequest;
import com.nttdata.microservice_yanki.model.YankiOperationResponse;
import com.nttdata.microservice_yanki.model.YankiRequest;
import com.nttdata.microservice_yanki.model.YankiResponse;
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
 * A delegate to be called by the {@link YankisApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-03T00:14:07.835996300-05:00[America/Lima]")
public interface YankisApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /yankis : Create a new yanki account
     *
     * @param yankiRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     * @see YankisApi#createYanki
     */
    default ResponseEntity<YankiResponse> createYanki(YankiRequest yankiRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"identifier\" : \"DNI\", \"phone\" : 957239780, \"identifierValue\" : \"123456789\", \"imei\" : \"123457238325\", \"email\" : \"juan.sanchez@gmail.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /yankis/{identifierValue} : Delete a yanki account by identifier
     *
     * @param identifierValue  (required)
     * @return No content (status code 204)
     *         or Invalid body supplied (status code 400)
     *         or Client not found (status code 404)
     * @see YankisApi#deleteYankiByIdentifier
     */
    default ResponseEntity<Void> deleteYankiByIdentifier(String identifierValue) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /yankis : Get all yanki accounts
     *
     * @return Successful Operation (status code 200)
     * @see YankisApi#getYankis
     */
    default ResponseEntity<List<YankiResponse>> getYankis() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"identifier\" : \"DNI\", \"phone\" : 957239780, \"identifierValue\" : \"123456789\", \"imei\" : \"123457238325\", \"email\" : \"juan.sanchez@gmail.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /yankis/payment : Pay amount with yanki
     *
     * @param yankiOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     * @see YankisApi#payment
     */
    default ResponseEntity<YankiOperationResponse> payment(YankiOperationRequest yankiOperationRequest) {
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
     * POST /yankis/withdraw : Withdraw amount with yanki
     *
     * @param yankiOperationRequest  (required)
     * @return Card created (status code 201)
     *         or Invalid input (status code 400)
     * @see YankisApi#withdraw
     */
    default ResponseEntity<YankiOperationResponse> withdraw(YankiOperationRequest yankiOperationRequest) {
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
