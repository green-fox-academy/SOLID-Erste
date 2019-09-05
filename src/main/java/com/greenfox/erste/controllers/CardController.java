package com.greenfox.erste.controllers;
import com.greenfox.erste.Models.CardValidatorInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.greenfox.erste.service.ICardService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
  public ResponseEntity<String> validateCard(@Valid @RequestBody CardValidatorInDTO validator) {
    if (cardService.existsCardByNumber(validator.getCardNumber())) {
      if(cardService.validateCard(validator)) {
        return ResponseEntity.ok("VALID");
      } else {
        return ResponseEntity.ok("INVALID");
      }
    }
     return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

