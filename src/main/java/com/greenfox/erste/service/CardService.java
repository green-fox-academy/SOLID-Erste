package com.greenfox.erste.service;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardValidatorInDTO;
import com.greenfox.erste.Models.CardInDTO;
import com.greenfox.erste.Models.CardOutDTO;
import com.greenfox.erste.repository.ICardRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
  public void save(Card card) {
    cardRepository.save(card);
  }

  @Override
  public Card findById(String id) {
    return cardRepository.findById(id).orElse(null);
  }

  @Override
  public boolean existsCardByNumber(String cardNumber) {
    return cardRepository.findById(cardNumber).isPresent();
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

  @Override
  public void delete(String id) {
    cardRepository.deleteById(id);
  }

  @Override
  public void invalidateCard(String id) {
    Card card = cardRepository.findById(id).orElse(null);
    card.setDisabled(true);
    cardRepository.save(card);
  }

  public Card convertFromDto(CardInDTO cardInDTO) {

    return modelMapper.map(cardInDTO, Card.class);
  }

  @Override
  public CardOutDTO convertToDto(Card card) {
    return modelMapper.map(card, CardOutDTO.class);
  }

}
