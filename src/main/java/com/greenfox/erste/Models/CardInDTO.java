package com.greenfox.erste.Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.greenfox.erste.Utils.ExpirationDateValidation;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class CardInDTO {
  @NotNull
  private String cardType;
  @NotNull
  @CreditCardNumber(ignoreNonDigitCharacters = true)
  @Size(min = 19, max = 19)
  private String cardNumber;
  @NotNull
  @Size(min = 5, max = 5)
  @JsonDeserialize(using = ExpirationDateValidation.class)
  private String validThru;
  @NotNull
  private String CVV;
  @NotNull
  private String owner;
  @NotNull
  private ContactInfo contact;

  public CardInDTO(){};

  public ContactInfo getContact() {
    return contact;
  }

  public void setContact(ContactInfo contact) {
    this.contact = contact;
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

  public String getCVV() {
    return CVV;
  }

  public void setCVV(String CVV) {
    this.CVV = CVV;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}
