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
 * AccountResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-11T11:26:26.684334100-05:00[America/Lima]")
public class AccountResponse   {
  @JsonProperty("balance")
  private Double balance;

  @JsonProperty("numberAccount")
  private String numberAccount;

  @JsonProperty("maintenanceFee")
  private Double maintenanceFee;

  @JsonProperty("monthlyMovements")
  private Integer monthlyMovements;

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

  public AccountResponse balance(Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  */
  @ApiModelProperty(example = "10.1", value = "")


  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public AccountResponse numberAccount(String numberAccount) {
    this.numberAccount = numberAccount;
    return this;
  }

  /**
   * Get numberAccount
   * @return numberAccount
  */
  @ApiModelProperty(example = "123456789", value = "")


  public String getNumberAccount() {
    return numberAccount;
  }

  public void setNumberAccount(String numberAccount) {
    this.numberAccount = numberAccount;
  }

  public AccountResponse maintenanceFee(Double maintenanceFee) {
    this.maintenanceFee = maintenanceFee;
    return this;
  }

  /**
   * Get maintenanceFee
   * @return maintenanceFee
  */
  @ApiModelProperty(example = "0", value = "")


  public Double getMaintenanceFee() {
    return maintenanceFee;
  }

  public void setMaintenanceFee(Double maintenanceFee) {
    this.maintenanceFee = maintenanceFee;
  }

  public AccountResponse monthlyMovements(Integer monthlyMovements) {
    this.monthlyMovements = monthlyMovements;
    return this;
  }

  /**
   * Get monthlyMovements
   * @return monthlyMovements
  */
  @ApiModelProperty(example = "3", value = "")


  public Integer getMonthlyMovements() {
    return monthlyMovements;
  }

  public void setMonthlyMovements(Integer monthlyMovements) {
    this.monthlyMovements = monthlyMovements;
  }

  public AccountResponse accountType(AccountTypeEnum accountType) {
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

  public AccountResponse clientId(List<String> clientId) {
    this.clientId = clientId;
    return this;
  }

  public AccountResponse addClientIdItem(String clientIdItem) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountResponse accountResponse = (AccountResponse) o;
    return Objects.equals(this.balance, accountResponse.balance) &&
        Objects.equals(this.numberAccount, accountResponse.numberAccount) &&
        Objects.equals(this.maintenanceFee, accountResponse.maintenanceFee) &&
        Objects.equals(this.monthlyMovements, accountResponse.monthlyMovements) &&
        Objects.equals(this.accountType, accountResponse.accountType) &&
        Objects.equals(this.clientId, accountResponse.clientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balance, numberAccount, maintenanceFee, monthlyMovements, accountType, clientId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountResponse {\n");
    
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    numberAccount: ").append(toIndentedString(numberAccount)).append("\n");
    sb.append("    maintenanceFee: ").append(toIndentedString(maintenanceFee)).append("\n");
    sb.append("    monthlyMovements: ").append(toIndentedString(monthlyMovements)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
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

