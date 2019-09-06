package com.greenfox.erste.controllers;

import com.greenfox.erste.models.Card;
import com.greenfox.erste.models.CardInDTO;
import com.greenfox.erste.models.CardOutDTO;
import com.greenfox.erste.models.CardValidatorInDTO;
import com.greenfox.erste.models.ContactInfo;
import com.greenfox.erste.service.ICardService;
import com.greenfox.erste.service.IContactInfoService;
import com.greenfox.erste.service.ILoggingService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/ecards")
public class CardController {

  private ICardService cardService;
  private IContactInfoService contactInfoService;
  private ILoggingService loggingService;

  CardController(ICardService cardService, IContactInfoService contactInfoService,
      ILoggingService loggingService) {
    this.cardService = cardService;
    this.contactInfoService = contactInfoService;
    this.loggingService = loggingService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{cardNumber}")
  public ResponseEntity getCard(@PathVariable String cardNumber) {
    Card newCard = cardService.findById(cardNumber);
    if (newCard == null) {
      loggingService.generateLogs("card number not found");
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