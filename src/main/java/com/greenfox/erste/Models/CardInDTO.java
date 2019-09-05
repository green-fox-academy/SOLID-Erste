package com.greenfox.erste.Models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class CardInDTO {
  @NotNull
  private String cardType;
  @NotNull
  private String cardNumber;
  @NotNull
  private String validThru;
  @NotNull
  private String CVV;
  @NotNull
  private String owner;
  @NotNull
  private ContactInfo contact;

  public CardInDTO(@NotNull String cardType, @NotNull String cardNumber, @NotNull String validThru, @NotNull String CVV, @NotNull String owner, @NotNull ContactInfo contact) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.validThru = validThru;
    this.CVV = CVV;
    this.owner = owner;
    this.contact = contact;
  }

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
