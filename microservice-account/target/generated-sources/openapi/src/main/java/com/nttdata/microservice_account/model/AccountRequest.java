package com.nttdata.microservice_account.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-01T23:18:36.228516500-05:00[America/Lima]")
public class AccountRequest   {
  /**
   * Gets or Sets accountType
   */
  public enum AccountTypeEnum {
    AHORRO("AHORRO"),
    
    CUENTA_CORRIENTE("CUENTA_CORRIENTE"),
    
    PLAZO_FIJO("PLAZO_FIJO");

    private String value;

    AccountTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AccountTypeEnum fromValue(String value) {
      for (AccountTypeEnum b : AccountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("accountType")
  private AccountTypeEnum accountType;

  @JsonProperty("clientId")
  @Valid
  private List<String> clientId = null;

  /**
   * Gets or Sets clientType
   */
  public enum ClientTypeEnum {
    PERSONAL("PERSONAL"),
    
    BUSINESS("BUSINESS");

    private String value;

    ClientTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ClientTypeEnum fromValue(String value) {
      for (ClientTypeEnum b : ClientTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("clientType")
  private ClientTypeEnum clientType;

  public AccountRequest accountType(AccountTypeEnum accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  */
  @ApiModelProperty(value = "")


  public AccountTypeEnum getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountTypeEnum accountType) {
    this.accountType = accountType;
  }

  public AccountRequest clientId(List<String> clientId) {
    this.clientId = clientId;
    return this;
  }

  public AccountRequest addClientIdItem(String clientIdItem) {
    if (this.clientId == null) {
      this.clientId = new ArrayList<>();
    }
    this.clientId.add(clientIdItem);
    return this;
  }

  /**
   * Get clientId
   * @return clientId
  */
  @ApiModelProperty(example = "[1234]", value = "")


  public List<String> getClientId() {
    return clientId;
  }

  public void setClientId(List<String> clientId) {
    this.clientId = clientId;
  }

  public AccountRequest clientType(ClientTypeEnum clientType) {
    this.clientType = clientType;
    return this;
  }

  /**
   * Get clientType
   * @return clientType
  */
  @ApiModelProperty(value = "")


  public ClientTypeEnum getClientType() {
    return clientType;
  }

  public void setClientType(ClientTypeEnum clientType) {
    this.clientType = clientType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountRequest accountRequest = (AccountRequest) o;
    return Objects.equals(this.accountType, accountRequest.accountType) &&
        Objects.equals(this.clientId, accountRequest.clientId) &&
        Objects.equals(this.clientType, accountRequest.clientType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountType, clientId, clientType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRequest {\n");
    
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientType: ").append(toIndentedString(clientType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

