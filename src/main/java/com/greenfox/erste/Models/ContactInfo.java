package com.greenfox.erste.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class ContactInfo {

  @NotNull
  private String type;
  @NotNull
  @Id
  @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
  private String contact;
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonBackReference
  private List<Card> cards = new ArrayList<>();

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

  public void addCard(Card newCard) {
    cards.add(newCard);
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
