package com.greenfox.erste.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardInDTO {
  @NotNull
  private String cardType;
  @NotNull
  @CreditCardNumber(ignoreNonDigitCharacters = true)
  @Size(min = 16, max = 19)
  private String cardNumber;
  @NotNull
  @Size(min = 5, max = 5)
  private String validThru;
  @NotNull
  private String cvv;
  @NotNull
  private String owner;
  @NotNull
  @JsonProperty("contact-info")
  private ContactInfo contactInfo;

  public CardInDTO(){}

  public ContactInfo getContact() {
    return contactInfo;
  }

  public void setContact(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getValidThru() {
    return validThru;
  }

  public void setValidThru(String validThru) {
    this.validThru = validThru;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}
