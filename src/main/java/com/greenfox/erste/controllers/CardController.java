package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.service.ICardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/")
public class CardController {

  private ICardService cardService;

  CardController(ICardService cardService) {
    this.cardService = cardService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/ecards/{cardNumber}")
  public ResponseEntity getCard(@PathVariable String cardNumber) {
    Card newCard = cardService.findById(cardNumber);
    if (newCard == null){
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(newCard);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/ecards/{cardNumber}")
  public ResponseEntity invalidateCard(@PathVariable String cardNumber){
    Card newCard = cardService.findById(cardNumber);
    if (newCard == null){
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    cardService.invalidateCard(cardNumber);
    return new ResponseEntity(HttpStatus.OK);
  }


}


