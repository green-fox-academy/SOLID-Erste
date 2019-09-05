package com.greenfox.erste.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ContactInfo {

//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private long id;
  @NotNull
  private String type;
  @NotNull
  @Id
  @Column(name = "contact", nullable = false,unique=true,columnDefinition="VARCHAR(64)")
  private String contact;
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonBackReference
  private List<Card> card = new ArrayList<>();

  public List<Card> getCard() {
    return card;
  }

  public void setCard(List<Card> card) {
    this.card = card;
  }

  public ContactInfo(@NotNull String type, @NotNull String contact, List<Card> card) {
    this.type = type;
    this.contact = contact;
    this.card = card;
  }

  public ContactInfo(){};


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
