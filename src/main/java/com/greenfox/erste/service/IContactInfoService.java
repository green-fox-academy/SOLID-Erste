package com.greenfox.erste.service;

import com.greenfox.erste.models.ContactInfo;
import java.util.List;

public interface IContactInfoService {
  List<ContactInfo> findAll();

  ContactInfo findById(long id);

  void save(ContactInfo contactInfo);

  void delete(long id);
}
