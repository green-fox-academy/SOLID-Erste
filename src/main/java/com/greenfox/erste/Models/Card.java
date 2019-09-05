package com.greenfox.erste.Models;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.List;

@Entity
public class Card {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String cardType;
  private String cardNumber;
  private String validThru;
  private String cardHash;
  private boolean disabled = false;
  private String owner;
  @OneToOne
  private ContactInfo contact;

  public Card(String cardType, String cardNumber, String validThru, boolean disabled, String owner, ContactInfo contact, String CVV) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.validThru = validThru;
    this.cardHash = createHash(cardNumber, validThru, CVV);
    this.disabled = disabled;
    this.owner = owner;
    this.contact = contact;

  }

  public Card(){}

  public long getId() {
    return id;
  }

  public String createHash(String cardNumber, String validThru, String CVV) {
    String cardNumberHash = DigestUtils.sha256Hex(cardNumber);
    String validThruHash = DigestUtils.sha256Hex(validThru);
    String CVVHash = DigestUtils.sha256Hex(CVV);
    String allHashes = cardNumberHash.concat(validThruHash).concat(CVVHash);
    String hashOutput = DigestUtils.sha256Hex(allHashes);
    return hashOutput;
  }

  public void setId(long id) {
    this.id = id;
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
