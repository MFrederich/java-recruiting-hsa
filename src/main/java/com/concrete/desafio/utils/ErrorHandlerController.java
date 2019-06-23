package com.concrete.desafio.utils;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorHandlerController {

  private static final String DEFAULT_ERROR_CODE = "0000";

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResponseEntity<ErrorDTO> handlerErrorException(Exception ex) {
    return new ResponseEntity<>(
        new ErrorDTO(DEFAULT_ERROR_CODE, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(FeignException.class)
  public ResponseEntity<ErrorDTO> handlerErrorFeignException(
      FeignException ex, HttpServletResponse response) {
    return new ResponseEntity<>(
        new ErrorDTO(Integer.toString(response.getStatus()), ex.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
