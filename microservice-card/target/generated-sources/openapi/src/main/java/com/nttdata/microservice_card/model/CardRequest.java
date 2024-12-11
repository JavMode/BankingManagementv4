package com.nttdata.microservice_card.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CardRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T01:56:00.145108700-05:00[America/Lima]")
public class CardRequest   {
  @JsonProperty("cardHolder")
  private String cardHolder;

  @JsonProperty("accounts")
  @Valid
  private List<String> accounts = null;

  public CardRequest cardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
    return this;
  }

  /**
   * Get cardHolder
   * @return cardHolder
  */
  @ApiModelProperty(example = "juan sanchez", value = "")


  public String getCardHolder() {
    return cardHolder;
  }

  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }

  public CardRequest accounts(List<String> accounts) {
    this.accounts = accounts;
    return this;
  }

  public CardRequest addAccountsItem(String accountsItem) {
    if (this.accounts == null) {
      this.accounts = new ArrayList<>();
    }
    this.accounts.add(accountsItem);
    return this;
  }

  /**
   * Get accounts
   * @return accounts
  */
  @ApiModelProperty(value = "")


  public List<String> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<String> accounts) {
    this.accounts = accounts;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardRequest cardRequest = (CardRequest) o;
    return Objects.equals(this.cardHolder, cardRequest.cardHolder) &&
        Objects.equals(this.accounts, cardRequest.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardHolder, accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardRequest {\n");
    
    sb.append("    cardHolder: ").append(toIndentedString(cardHolder)).append("\n");
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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

