package com.greenfox.erste.controllers;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.CardOutDTO;
import com.greenfox.erste.service.ICardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.greenfox.erste.Models.CardInDTO;
import com.greenfox.erste.Models.CardValidatorInDTO;
import com.greenfox.erste.Models.ContactInfo;
import com.greenfox.erste.service.IContactInfoService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/ecards")
public class CardController {

  private ICardService cardService;
  private IContactInfoService contactInfoService;

  CardController(ICardService cardService, IContactInfoService contactInfoService) {
    this.cardService = cardService;
    this.contactInfoService = contactInfoService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{cardNumber}")
  public ResponseEntity getCard(@PathVariable String cardNumber) {
    Card newCard = cardService.findById(cardNumber);
    if (newCard == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    CardOutDTO cardToReturn = cardService.convertToDto(newCard);
    return ResponseEntity.ok(cardToReturn);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{cardNumber}")
  public ResponseEntity invalidateCard(@PathVariable String cardNumber) {
    cardService.invalidateCard(cardNumber);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/")
  @ResponseBody
  public ResponseEntity addNewCard(@Valid @RequestBody CardInDTO newCardInDTO) {
    ContactInfo tempContactInfo = newCardInDTO.getContact();
    if (cardService.existsCardByNumber(newCardInDTO.getCardNumber())) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (!contactInfoService.findAll().contains(tempContactInfo)) {
      contactInfoService.save(tempContactInfo);
    }
    Card cardToAdd = cardService.convertFromDto(newCardInDTO);
    cardService.save(cardToAdd);
    return new ResponseEntity(HttpStatus.OK);

  }

  @PostMapping("/validate")
  public ResponseEntity<String> validateCard(@Valid @RequestBody CardValidatorInDTO validator) {
    if (cardService.validateCard(validator)) {
      return ResponseEntity.ok("VALID");
    } else {
      return ResponseEntity.ok("INVALID");
    }
  }
}