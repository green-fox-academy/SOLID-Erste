package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardInDTO;
import com.greenfox.erste.Models.CardOutDTO;
import com.greenfox.erste.repository.ICardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardService {

  private ICardRepository cardRepository;
  private ModelMapper modelMapper;

  public CardService(ICardRepository cardRepository, ModelMapper modelMapper) {
    this.cardRepository = cardRepository;
    this.modelMapper = modelMapper;

  }

  @Override
  public List<Card> findAll() {
    List<Card> cardList = new ArrayList<>();
    cardRepository.findAll().forEach(cardList::add);
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

  public CardOutDTO convertToDto(Card card) {
    return modelMapper.map(card, CardOutDTO.class);
  }

  public Card convertFromDto(CardInDTO cardInDTO) {
    return modelMapper.map(cardInDTO, Card.class);
  }
}
