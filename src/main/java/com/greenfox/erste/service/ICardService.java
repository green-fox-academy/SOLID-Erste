package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;

import java.util.List;

public interface ICardService {
  List<Card> findAll();

  Card findById(String id);

  void save(Card card);

  void delete(String id);
}
