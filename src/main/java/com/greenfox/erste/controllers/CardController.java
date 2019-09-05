package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardInDTO;
import com.greenfox.erste.Models.CardValidatorInDTO;
import com.greenfox.erste.Models.ContactInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.greenfox.erste.service.ICardService;
import org.springframework.web.bind.annotation.RequestBody;
import com.greenfox.erste.service.IContactInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

  @PostMapping("ecards")
  @ResponseBody
  public ResponseEntity addNewCard(@Valid @RequestBody CardInDTO newCardInDTO) {
    ContactInfo tempContactInfo = newCardInDTO.getContact();
    if (!contactInfoService.findAll().contains(tempContactInfo)) {
      contactInfoService.save(tempContactInfo);
    }
    Card cardToAdd = cardService.convertFromDto(newCardInDTO);
    cardService.save(cardToAdd);
    return new ResponseEntity(HttpStatus.OK);
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

