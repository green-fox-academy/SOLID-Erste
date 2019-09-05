package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardInDTO;
import com.greenfox.erste.Models.ContactInfo;
import com.greenfox.erste.service.ICardService;
import com.greenfox.erste.service.IContactInfoService;
import javax.validation.Valid;
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
  private IContactInfoService contactInfoService;

  CardController(ICardService cardService, IContactInfoService contactInfoService) {
    this.cardService = cardService;
    this.contactInfoService = contactInfoService;
  }

  CardController() {

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
}

