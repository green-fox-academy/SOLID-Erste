package com.greenfox.erste.Models;

import javax.validation.constraints.NotNull;

public class ContactInfo {
  @NotNull
  private String type;
  @NotNull
  private String contact;
}
