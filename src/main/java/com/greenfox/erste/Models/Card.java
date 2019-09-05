package com.greenfox.erste.Models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Card {
  private String cardType;
  private String cardNumber;
  private String validThru;
  private String cardHash;
  private boolean disabled;
  private String owner;
  private ContactInfo contact;

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

  public String getCardHash() {
    return cardHash;
  }

  public void setCardHash(String cardHash) {
    this.cardHash = cardHash;
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
