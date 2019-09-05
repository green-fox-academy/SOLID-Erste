package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardValidatorInDTO;
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
  public void save(Card card) {
    cardRepository.save(card);
  }

  @Override
  public Card findById(String id) {
    return cardRepository.findById(id).orElse(null);
  }

  @Override
  public boolean existsCardByNumber(String cardNumber) {
    return cardRepository.findById(cardNumber) != null;
  }

  @Override
  public boolean validateCard(CardValidatorInDTO validator) {
    Card cardToValidate = findById(validator.getCardNumber());
    return typeNumberValidChecker(validator, cardToValidate) &&
            !cardToValidate.isDisabled() &&
            hashesEqual(validator, cardToValidate);
  }

  @Override
  public boolean typeNumberValidChecker(CardValidatorInDTO validator, Card card) {
    return validator.getCardType().equals(card.getCardType()) &&
            validator.getCardNumber().equals(card.getCardNumber()) &&
            validator.getValidThru().equals(card.getValidThru());
  }

  @Override
  public boolean hashesEqual(CardValidatorInDTO validator, Card card) {
    String validatorHash = card.createHash(validator.getCardNumber(), validator.getValidThru(), validator.getCvv());
    return validatorHash.equals(card.getCardHash());
  }
}
