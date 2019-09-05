package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.CardValidatorInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.greenfox.erste.service.ICardService;
import org.springframework.web.bind.annotation.RequestBody;
import com.greenfox.erste.service.IContactInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class CardController {

  private ICardService cardService;
  private IContactInfoService contactInfoService;

  CardController(ICardService cardService, IContactInfoService contactInfoService) {
    this.cardService = cardService;
    this.contactInfoService = contactInfoService;
  }

  @PostMapping("/ecards/validate")
  public ResponseEntity<String> validateCard(@Valid @RequestBody CardValidatorInDTO validator) {
    if (cardService.validateCard(validator)) {
      return ResponseEntity.ok("VALID");
    } else {
      return ResponseEntity.ok("INVALID");
    }
  }
}

