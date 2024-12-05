package com.nttdata.microservice_yanki.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * YankiRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-03T00:14:07.835996300-05:00[America/Lima]")
public class YankiRequest   {
  /**
   * Gets or Sets identifier
   */
  public enum IdentifierEnum {
    DNI("DNI"),
    
    CEX("CEX"),
    
    PASSPORT("PASSPORT");

    private String value;

    IdentifierEnum(String value) {
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
    public static IdentifierEnum fromValue(String value) {
      for (IdentifierEnum b : IdentifierEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("identifier")
  private IdentifierEnum identifier;

  @JsonProperty("identifierValue")
  private String identifierValue;

  @JsonProperty("phone")
  private Integer phone;

  @JsonProperty("imei")
  private String imei;

  @JsonProperty("email")
  private String email;

  public YankiRequest identifier(IdentifierEnum identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * Get identifier
   * @return identifier
  */
  @ApiModelProperty(value = "")


  public IdentifierEnum getIdentifier() {
    return identifier;
  }

  public void setIdentifier(IdentifierEnum identifier) {
    this.identifier = identifier;
  }

  public YankiRequest identifierValue(String identifierValue) {
    this.identifierValue = identifierValue;
    return this;
  }

  /**
   * Get identifierValue
   * @return identifierValue
  */
  @ApiModelProperty(example = "123456789", value = "")


  public String getIdentifierValue() {
    return identifierValue;
  }

  public void setIdentifierValue(String identifierValue) {
    this.identifierValue = identifierValue;
  }

  public YankiRequest phone(Integer phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @ApiModelProperty(example = "957239780", value = "")


  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

  public YankiRequest imei(String imei) {
    this.imei = imei;
    return this;
  }

  /**
   * Get imei
   * @return imei
  */
  @ApiModelProperty(example = "123457238325", value = "")


  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public YankiRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(example = "juan.sanchez@gmail.com", value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    YankiRequest yankiRequest = (YankiRequest) o;
    return Objects.equals(this.identifier, yankiRequest.identifier) &&
        Objects.equals(this.identifierValue, yankiRequest.identifierValue) &&
        Objects.equals(this.phone, yankiRequest.phone) &&
        Objects.equals(this.imei, yankiRequest.imei) &&
        Objects.equals(this.email, yankiRequest.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, identifierValue, phone, imei, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class YankiRequest {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    identifierValue: ").append(toIndentedString(identifierValue)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    imei: ").append(toIndentedString(imei)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

