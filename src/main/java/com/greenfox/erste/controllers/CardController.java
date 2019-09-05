package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.service.ICardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/")
public class CardController {

  private ICardService cardService;

  CardController(ICardService cardService) {
    this.cardService = cardService;
  }

  @RequestMapping("/ecards/{cardNumber}")
  public ResponseEntity getCard(@PathVariable String cardNumber) throws Exception {
    Card newCard = cardService.findById(cardNumber);
    if (newCard == null){
     return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(newCard);
  }
}


