package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;

import com.greenfox.erste.Models.CardInDTO;
import com.greenfox.erste.Models.CardOutDTO;
import java.util.List;

public interface ICardService {

  List<Card> findAll();

  Card findById(String id);

  void save(Card card);

  Card convertFromDto(CardInDTO cardInDTO);

  CardOutDTO convertToDto(Card card);

  void delete(String id);

}
