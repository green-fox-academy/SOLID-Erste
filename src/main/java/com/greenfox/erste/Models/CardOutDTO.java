package com.greenfox.erste.Models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class CardOutDTO {
  private String cardType;
  private String cardNumber;
  private String validThru;
  private boolean disabled;
  private String owner;
  private ContactInfo contact;

  public CardOutDTO(String cardType, String cardNumber, String validThru, boolean disabled, String owner, ContactInfo contact) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.validThru = validThru;
    this.disabled = disabled;
    this.owner = owner;
    this.contact = contact;
  }

  public CardOutDTO(){};

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

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}
