package com.greenfox.erste.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ContactInfo {
  @Id
  private long id;
  @NotNull
  private String type;
  @NotNull
  private String contact;

  public ContactInfo(@NotNull String type, @NotNull String contact) {
    this.type = type;
    this.contact = contact;
  }

  public ContactInfo(){};

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
