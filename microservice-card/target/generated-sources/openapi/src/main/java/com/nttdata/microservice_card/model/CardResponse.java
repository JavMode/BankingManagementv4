package com.nttdata.microservice_card.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CardResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T01:56:00.145108700-05:00[America/Lima]")
public class CardResponse   {
  @JsonProperty("cardHolder")
  private String cardHolder;

  @JsonProperty("accounts")
  @Valid
  private List<String> accounts = null;

  @JsonProperty("cardNumber")
  private String cardNumber;

  @JsonProperty("cvv")
  private Integer cvv;

  @JsonProperty("expiryDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate expiryDate;

  public CardResponse cardHolder(String cardHolder) {
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

  public CardResponse accounts(List<String> accounts) {
    this.accounts = accounts;
    return this;
  }

  public CardResponse addAccountsItem(String accountsItem) {
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

  public CardResponse cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Get cardNumber
   * @return cardNumber
  */
  @ApiModelProperty(example = "2190382193217231", value = "")


  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CardResponse cvv(Integer cvv) {
    this.cvv = cvv;
    return this;
  }

  /**
   * Get cvv
   * @return cvv
  */
  @ApiModelProperty(example = "956", value = "")


  public Integer getCvv() {
    return cvv;
  }

  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }

  public CardResponse expiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Get expiryDate
   * @return expiryDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardResponse cardResponse = (CardResponse) o;
    return Objects.equals(this.cardHolder, cardResponse.cardHolder) &&
        Objects.equals(this.accounts, cardResponse.accounts) &&
        Objects.equals(this.cardNumber, cardResponse.cardNumber) &&
        Objects.equals(this.cvv, cardResponse.cvv) &&
        Objects.equals(this.expiryDate, cardResponse.expiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardHolder, accounts, cardNumber, cvv, expiryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardResponse {\n");
    
    sb.append("    cardHolder: ").append(toIndentedString(cardHolder)).append("\n");
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    cvv: ").append(toIndentedString(cvv)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
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

