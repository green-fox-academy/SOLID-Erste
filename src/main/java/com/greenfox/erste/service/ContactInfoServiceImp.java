package com.greenfox.erste.service;

import ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator;
import com.greenfox.erste.repository.ICardRepository;
import com.greenfox.erste.repository.IContactInfoRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactInfoServiceImp implements IContactInfoService {
  private IContactInfoRepository contactInfoRepository;

  public ContactInfoServiceImp(IContactInfoRepository contactInfoRepository) {
    this.contactInfoRepository = contactInfoRepository;
  }

  @Override
  public List<ContactInfo> findAll() {
    List<ContactInfo> contactInfoList = new ArrayList<>();
    contactInfoRepository.findAll().forEach(contactInfoList::add);
    return contactInfoList;
  }

  @Override
  public ContactInfo findById(long id) {
    ContactInfo contactInfo = contactInfoRepository.findById(id).orElse(null);
    return contactInfo;
  }

  @Override
  public void save(ContactInfo contactInfo) {
  contactInfoRepository.save(contactInfo);
  }

  @Override
  public void delete(long id) {
    contactInfoRepository.deleteById(id);
  }
}
