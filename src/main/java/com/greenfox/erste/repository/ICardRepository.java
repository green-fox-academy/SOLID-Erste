package com.greenfox.erste.repository;

import com.greenfox.erste.Models.Card;
import org.springframework.data.repository.CrudRepository;

public interface ICardRepository extends CrudRepository<Card, Long>{
  Card findCardByCardNumber(String cardNumber);
}
