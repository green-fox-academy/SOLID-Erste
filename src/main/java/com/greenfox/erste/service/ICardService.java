package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardValidatorInDTO;

import java.util.List;

public interface ICardService {
  List<Card> findAll();

  void save(Card card);

  Card findById(String id);

  boolean existsCardByNumber(String cardNumber);

  boolean validateCard(CardValidatorInDTO validator);

  boolean typeNumberValidChecker(CardValidatorInDTO validator, Card card);

  boolean hashesEqual(CardValidatorInDTO validator, Card card);
}
