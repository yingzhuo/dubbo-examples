package de.consumer.controller.adv;

import de.service.exception.NotImplementedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ExceptionHandlerAdvice {

    @ExceptionHandler
    String exclude(NotImplementedException e) {
        return String.format("本功能未实现，请联系%s", e.getOwner());
    }

}
