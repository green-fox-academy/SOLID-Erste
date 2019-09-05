package com.greenfox.erste.Models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(ContactInfoId.class)
public class ContactInfo {

  @NotNull
  @Id
  private String type;
  @NotNull
  @Id
  private String contact;
  @OneToMany
  private List<Card> cards;

  public ContactInfo(@NotNull String type, @NotNull String contact, List<Card> cards) {
    this.type = type;
    this.contact = contact;
    this.cards = cards;
  }

  public ContactInfo() {
  }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
}
