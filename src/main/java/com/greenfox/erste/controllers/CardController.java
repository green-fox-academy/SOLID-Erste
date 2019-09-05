package com.greenfox.erste.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import com.greenfox.erste.service.ICardService;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @PostMapping("/ecards/validate")
  public String validateCard() {

  }

}

