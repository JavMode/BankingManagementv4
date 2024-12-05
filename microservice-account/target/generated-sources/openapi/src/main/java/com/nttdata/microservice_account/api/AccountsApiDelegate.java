package com.nttdata.microservice_account.api;

import com.nttdata.microservice_account.model.AccountRequest;
import com.nttdata.microservice_account.model.AccountResponse;
import com.nttdata.microservice_account.model.VipAccountRequest;
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
 * A delegate to be called by the {@link AccountsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-01T23:18:36.228516500-05:00[America/Lima]")
public interface AccountsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /accounts : Create a new account
     *
     * @param accountRequest  (required)
     * @return Account created (status code 201)
     *         or Invalid input (status code 400)
     * @see AccountsApi#createAccount
     */
    default ResponseEntity<AccountResponse> createAccount(AccountRequest accountRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyMovements\" : 3, \"maintenanceFee\" : 0, \"clientId\" : [ 1234 ], \"balance\" : 10.1, \"accountType\" : \"AHORRO\", \"numberAccount\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /accounts/mype : Create a new mype account
     *
     * @param vipAccountRequest  (required)
     * @return Account created (status code 201)
     *         or Invalid input (status code 400)
     * @see AccountsApi#createMypeAccount
     */
    default ResponseEntity<AccountResponse> createMypeAccount(VipAccountRequest vipAccountRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyMovements\" : 3, \"maintenanceFee\" : 0, \"clientId\" : [ 1234 ], \"balance\" : 10.1, \"accountType\" : \"AHORRO\", \"numberAccount\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /accounts/vip : Create a new vip account
     *
     * @param vipAccountRequest  (required)
     * @return Account created (status code 201)
     *         or Invalid input (status code 400)
     * @see AccountsApi#createVipAccount
     */
    default ResponseEntity<AccountResponse> createVipAccount(VipAccountRequest vipAccountRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyMovements\" : 3, \"maintenanceFee\" : 0, \"clientId\" : [ 1234 ], \"balance\" : 10.1, \"accountType\" : \"AHORRO\", \"numberAccount\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /accounts/{accountNumber} : Delete an account by ID
     *
     * @param accountNumber  (required)
     * @return No content (status code 204)
     *         or Invalid ID supplied (status code 400)
     *         or Account not found (status code 404)
     * @see AccountsApi#deleteAccountById
     */
    default ResponseEntity<Void> deleteAccountById(String accountNumber) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /accounts/{accountNumber} : Find account by ID
     *
     * @param accountNumber ID of account to return (required)
     * @return Operation successful (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Account not found (status code 404)
     * @see AccountsApi#findAccountById
     */
    default ResponseEntity<AccountResponse> findAccountById(String accountNumber) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyMovements\" : 3, \"maintenanceFee\" : 0, \"clientId\" : [ 1234 ], \"balance\" : 10.1, \"accountType\" : \"AHORRO\", \"numberAccount\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /accounts : Get all accounts
     *
     * @return Successful Operation (status code 200)
     * @see AccountsApi#getAccounts
     */
    default ResponseEntity<List<AccountResponse>> getAccounts() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyMovements\" : 3, \"maintenanceFee\" : 0, \"clientId\" : [ 1234 ], \"balance\" : 10.1, \"accountType\" : \"AHORRO\", \"numberAccount\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /accounts/client/{id} : Find all accounts of a client
     *
     * @param id ID of account to return (required)
     * @return Operation successful (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Account not found (status code 404)
     * @see AccountsApi#getAccountsOfClient
     */
    default ResponseEntity<List<AccountResponse>> getAccountsOfClient(List<String> id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyMovements\" : 3, \"maintenanceFee\" : 0, \"clientId\" : [ 1234 ], \"balance\" : 10.1, \"accountType\" : \"AHORRO\", \"numberAccount\" : \"123456789\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
