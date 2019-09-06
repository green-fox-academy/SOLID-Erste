package com.greenfox.erste.service;

import com.greenfox.erste.controllers.CardController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService implements ILoggingService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

  @Override
  public void generateLogs(final String value) {
    LOGGER.trace("LogGenerator: more information - {}", value);
    LOGGER.debug("LogGenerator: needed to debug - {}", value);
    LOGGER.info("LogGenerator: took input - {}", value);
    LOGGER.warn("LogGenerator: needed to warn - {}", value);
    LOGGER.error("LogGenerator: encountered an error - {}", value);
  }
}
