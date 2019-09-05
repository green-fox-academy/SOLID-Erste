package com.greenfox.erste.service;

import com.greenfox.erste.Models.ContactInfo;
import com.greenfox.erste.repository.IContactInfoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactInfoService implements IContactInfoService {

  private IContactInfoRepository contactInfoRepository;

  public ContactInfoService(IContactInfoRepository contactInfoRepository) {
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
    return contactInfoRepository.findById(id).orElse(null);
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
