package com.greenfox.erste.repository;

import com.greenfox.erste.models.ContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface IContactInfoRepository  extends CrudRepository<ContactInfo, Long> {
}
