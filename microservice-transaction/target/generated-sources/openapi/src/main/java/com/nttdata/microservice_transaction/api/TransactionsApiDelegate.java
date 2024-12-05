package com.nttdata.microservice_transaction.api;

import com.nttdata.microservice_transaction.model.TransactionRequest;
import com.nttdata.microservice_transaction.model.TransactionResponse;
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
 * A delegate to be called by the {@link TransactionsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-21T11:58:34.060029300-05:00[America/Lima]")
public interface TransactionsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /transactions/credit/consumption/{accountNumber} : Register a transaction
     *
     * @param accountNumber account number of transaction to return (required)
     * @param transactionRequest  (required)
     * @return Transaction registered (status code 201)
     *         or Invalid input (status code 400)
     * @see TransactionsApi#consumptionCredit
     */
    default ResponseEntity<TransactionResponse> consumptionCredit(String accountNumber,
        TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"transactionType\" : \"DEPOSITO\", \"amount\" : 10.0, \"id\" : \"1\", \"accountNumber\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transactions/account/deposit/{accountNumber} : Register a transaction
     *
     * @param accountNumber account number of transaction to return (required)
     * @param transactionRequest  (required)
     * @return Transaction registered (status code 201)
     *         or Invalid input (status code 400)
     * @see TransactionsApi#depositAccount
     */
    default ResponseEntity<TransactionResponse> depositAccount(String accountNumber,
        TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"transactionType\" : \"DEPOSITO\", \"amount\" : 10.0, \"id\" : \"1\", \"accountNumber\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /transactions/{id} : Find transaction by ID
     *
     * @param id ID of transaction to return (required)
     * @return Operation successful (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Credit not found (status code 404)
     * @see TransactionsApi#findTransactionById
     */
    default ResponseEntity<TransactionResponse> findTransactionById(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"transactionType\" : \"DEPOSITO\", \"amount\" : 10.0, \"id\" : \"1\", \"accountNumber\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transactions/credit/payment/{accountNumber} : Register a transaction
     *
     * @param accountNumber account number of transaction to return (required)
     * @param transactionRequest  (required)
     * @return Transaction registered (status code 201)
     *         or Invalid input (status code 400)
     * @see TransactionsApi#paymentCredit
     */
    default ResponseEntity<TransactionResponse> paymentCredit(String accountNumber,
        TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"transactionType\" : \"DEPOSITO\", \"amount\" : 10.0, \"id\" : \"1\", \"accountNumber\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transactions/account/withdraw/{accountNumber} : Register a transaction
     *
     * @param accountNumber account number of transaction to return (required)
     * @param transactionRequest  (required)
     * @return Transaction registered (status code 201)
     *         or Invalid input (status code 400)
     * @see TransactionsApi#withdrawAccount
     */
    default ResponseEntity<TransactionResponse> withdrawAccount(String accountNumber,
        TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"transactionType\" : \"DEPOSITO\", \"amount\" : 10.0, \"id\" : \"1\", \"accountNumber\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
