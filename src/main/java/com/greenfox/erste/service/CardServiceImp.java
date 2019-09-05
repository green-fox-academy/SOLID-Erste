package com.greenfox.erste.service;

import com.greenfox.erste.repository.ICardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImp implements ICardService {
  private ICardRepository cardRepository;

  public CardServiceImp(ICardRepository orderRepository) {
    this.cardRepository = orderRepository;
  }

  @Override
  public List<Card> findAll() {
    List<Card> cardList = new ArrayList<>();
    cardRepository.FindAll().forEach(cardList::add);
    return cardList;
  }

  @Override
  public Card findById(long id) {
    return cardRepository.findById(id).orElse(null);
  }

  @Override
  public void save(Card card) {
    cardRepository.save(card);
  }

  @Override
  public void delete(long id) {
    cardRepository.deleteById(id);
  }
}
