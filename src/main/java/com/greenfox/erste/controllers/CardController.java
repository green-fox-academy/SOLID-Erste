package com.greenfox.erste.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CardController {

  private ICardService cardService;

  CardController(ICardService cardService) {
    this.cardService = cardService;
  }
    CardController() {

  }

  @PostMapping("ecards")
  @ResponseBody
  public ResponseEntity addCard(/*@RequestBody CardInDTO newCard*/) {

    if (1 == 1) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    } else {
      return new ResponseEntity(HttpStatus.OK);
    }

  }
}

