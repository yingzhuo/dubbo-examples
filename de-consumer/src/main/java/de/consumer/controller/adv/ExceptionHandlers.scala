package de.consumer.controller.adv

import de.service.exception.NotImplemented
import org.springframework.web.bind.annotation.{ExceptionHandler, RestControllerAdvice}

@RestControllerAdvice
private class ExceptionHandlers {

  @ExceptionHandler
  def exclude(e: NotImplemented): String = e.getMessage

}
