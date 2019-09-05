package com.greenfox.erste.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(ContactInfoId.class)
public class ContactInfo {
//  @Id
//  private long id;
  @NotNull
  @Id
  private String type;
  @NotNull
  @Id
  private String contact;
  @OneToMany
  @NotNull
  private Card card;

  public ContactInfo(@NotNull String type, @NotNull String contact, @NotNull Card card) {
    this.type = type;
    this.contact = contact;
    this.card = card;
  }

  public ContactInfo(){}

//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }

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
