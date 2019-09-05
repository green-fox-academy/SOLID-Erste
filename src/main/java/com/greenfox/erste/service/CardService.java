package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.repository.ICardRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardService {
  private ICardRepository cardRepository;

  public CardService(ICardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

  @Override
  public List<Card> findAll() {
    List<Card> cardList = new ArrayList<>();
    cardRepository.findAll().forEach(cardList::add);
    return cardList;
  }

  @Override
  public Card findById(String id) {
    return cardRepository.findById(id).orElse(null);
  }

  @Override
  public void save(Card card) {
    cardRepository.save(card);
  }

  @Override
  public void delete(String id) {
    cardRepository.deleteById(id);
  }
}
