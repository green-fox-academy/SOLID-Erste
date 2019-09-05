package com.greenfox.erste.Models;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardValidatorInDTO {
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
  @Size(min = 3, max = 3)
  private String cvv;

  public CardValidatorInDTO() {
  }

  public CardValidatorInDTO(String cardType, String cardNumber, String validThru, String cvv) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.validThru = validThru;
    this.cvv = cvv;
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
}
