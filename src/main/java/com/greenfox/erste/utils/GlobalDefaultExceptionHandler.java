package com.greenfox.erste.utils;

import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalDefaultExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public void defaultErrorHandler(HttpServletResponse response, Exception e) throws Exception {
    response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    if (AnnotationUtils.findAnnotation
        (e.getClass(), ResponseStatus.class) != null) {
      throw e;
    }
  }
}
