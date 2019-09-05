package com.greenfox.erste.service;

import java.util.List;

public interface ICardService {
  List<Card> findAll();

  Card findById(long id);

  void save(Card card);

  void delete(long id);
}
