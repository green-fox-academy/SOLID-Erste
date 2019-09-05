package com.greenfox.erste.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;


@Entity
public class Card {

  private String cardType;
  @Id
  @Column(name = "card_number", nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
  private String cardNumber;
  private String validThru;
  private String cardHash;
  private boolean disabled = false;
  private String owner;
  @ManyToOne
  private ContactInfo contact;

  public Card(String cardType, String cardNumber, String validThru, String cardHash,
      boolean disabled, String owner, ContactInfo contact) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.validThru = validThru;
    this.cardHash = cardHash;
    this.disabled = disabled;
    this.owner = owner;
    this.contact = contact;
  }

  public Card() {
  }

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
