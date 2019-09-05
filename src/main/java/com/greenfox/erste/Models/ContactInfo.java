package com.greenfox.erste.Models;

import javax.validation.constraints.NotNull;

public class ContactInfo {
  @NotNull
  private String type;
  @NotNull
  private String contact;

  public ContactInfo(@NotNull String type, @NotNull String contact) {
    this.type = type;
    this.contact = contact;
  }

  public ContactInfo(){};
}
