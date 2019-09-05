package com.greenfox.erste.Utils;

import com.greenfox.erste.Models.Card;
import com.greenfox.erste.Models.ContactInfo;
import com.greenfox.erste.repository.ICardRepository;
import com.greenfox.erste.repository.IContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
      ContactInfo newContact = new ContactInfo("sms", "19" + i);
      ContactInfo anotherContact = new ContactInfo("sms", "18" + i);
      Card newCard = new Card("Visa",
          "540720070266639" +i,
          "12/20",
          false,
          "Stan Smith",
          null,
              "123"
      );
      Card anotherCard = new Card("Visa",
          "200010001000100" +i,
          "12/20",
          false,
          "Mat Smith",
          null,
              "123"
      );
      infoRepo.save(newContact);
      newCard.setContact(newContact);
      cardRepo.save(newCard);
      newContact.setCard(newCard);
      infoRepo.save(newContact);

      infoRepo.save(anotherContact);
      anotherCard.setContact(anotherContact);
      cardRepo.save(anotherCard);
      anotherContact.setCard(anotherCard);
      infoRepo.save(anotherContact);


    }
  }
}
