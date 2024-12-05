package com.nttdata.microservice_card.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CardOperationRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T01:56:00.145108700-05:00[America/Lima]")
public class CardOperationRequest   {
  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("cardNumber")
  private String cardNumber;

  @JsonProperty("cvv")
  private Integer cvv;

  @JsonProperty("expiryDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate expiryDate;

  public CardOperationRequest amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @ApiModelProperty(example = "23.5", value = "")


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public CardOperationRequest cardNumber(String cardNumber) {
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

  public CardOperationRequest cvv(Integer cvv) {
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

  public CardOperationRequest expiryDate(LocalDate expiryDate) {
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
    CardOperationRequest cardOperationRequest = (CardOperationRequest) o;
    return Objects.equals(this.amount, cardOperationRequest.amount) &&
        Objects.equals(this.cardNumber, cardOperationRequest.cardNumber) &&
        Objects.equals(this.cvv, cardOperationRequest.cvv) &&
        Objects.equals(this.expiryDate, cardOperationRequest.expiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, cardNumber, cvv, expiryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardOperationRequest {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

