package com.greenfox.erste.Models;

import java.io.Serializable;

public class ContactInfoId implements Serializable {

  private String type;

  private String contact;

  public ContactInfoId(String type, String contact) {
    this.type = type;
    this.contact = contact;
  }

}
