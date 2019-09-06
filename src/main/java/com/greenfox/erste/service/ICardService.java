package com.greenfox.erste.service;

import com.greenfox.erste.models.Card;
import com.greenfox.erste.models.CardValidatorInDTO;

import com.greenfox.erste.models.CardInDTO;
import com.greenfox.erste.models.CardOutDTO;
import java.util.List;

public interface ICardService {

  List<Card> findAll();

  void save(Card card);

  Card findById(String id);

  boolean existsCardByNumber(String cardNumber);

  boolean validateCard(CardValidatorInDTO validator);

  boolean typeNumberValidChecker(CardValidatorInDTO validator, Card card);

  boolean hashesEqual(CardValidatorInDTO validator, Card card);

  void delete(String id);

  void invalidateCard(String id);

  Card convertFromDto(CardInDTO cardInDTO);

  CardOutDTO convertToDto(Card card);

}
