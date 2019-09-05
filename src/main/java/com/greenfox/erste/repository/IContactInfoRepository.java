package com.greenfox.erste.repository;

import com.greenfox.erste.Models.ContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface IContactInfoRepository  extends CrudRepository<ContactInfo, Long> {
}
