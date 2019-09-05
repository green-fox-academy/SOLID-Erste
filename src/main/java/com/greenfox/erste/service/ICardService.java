package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;

import java.util.List;

public interface ICardService {
  List<Card> findAll();

  Card findById(long id);

  void save(Card card);

  void delete(long id);
}
