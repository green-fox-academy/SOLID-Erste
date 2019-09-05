package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.service.ICardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CardController {

  private ICardService cardService;

  CardController(ICardService cardService) {
    this.cardService = cardService;
  }

  @RequestMapping("/ecards/{cardNumber}")
  public Card getCard(@PathVariable String cardNumber){
    Card newCard = cardService.findById(cardNumber);
    return newCard;
  }
}


