package com.greenfox.erste.Utils;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.ContactInfo;
import com.greenfox.erste.repository.ICardRepository;
import com.greenfox.erste.repository.IContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements ApplicationRunner {

  private ICardRepository cardRepo;
  private IContactInfoRepository infoRepo;

  public DataSeeder(ICardRepository cardRepo, IContactInfoRepository infoRepo) {
    this.cardRepo = cardRepo;
    this.infoRepo = infoRepo;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    for (int i = 0; i < 10; i++) {
//      ContactInfo anotherContact = new ContactInfo("sms", "18" + i);
//      infoRepo.save(anotherContact);
      Card newCard = new Card("Visa",
          "100010001000100" +i,
          "12/20",
          "thisisatesthash",
          false,
          "Stan Smith",
          null
      );
      Card anotherCard = new Card("Visa",
          "200010001000100" +i,
          "12/20",
          "thisisatesthash",
          false,
          "Mat Smith",
          null
      );
      List<Card> cardList = new ArrayList<>();
      cardList.add(newCard);
      cardList.add(anotherCard);

      ContactInfo newContact = new ContactInfo("sms", "19" + i, cardList);
      infoRepo.save(newContact);
      newCard.setContact(newContact);
      anotherCard.setContact(newContact);
      cardRepo.save(newCard);
      cardRepo.save(anotherCard);
    }
  }
}
