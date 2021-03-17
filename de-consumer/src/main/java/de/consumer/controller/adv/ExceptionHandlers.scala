package de.consumer.controller.adv

import de.service.exception.NotImplemented
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.{ExceptionHandler, ResponseStatus, RestControllerAdvice}

@RestControllerAdvice
private class ExceptionHandlers {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  def exclude(e: NotImplemented): String = e.getMessage

}
