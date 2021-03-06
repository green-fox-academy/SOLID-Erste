package com.greenfox.erste.Models;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
  @Pattern(regexp = "(?:0[1-9]|1[0-2])/[0-9]{2}")
  private String validThru;
  @NotNull
  @Size(min = 3, max = 3)
  private String cvv;
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
    return cvv;
  }
  
  public void setCVV(String cvv) {
    this.cvv = cvv;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}
