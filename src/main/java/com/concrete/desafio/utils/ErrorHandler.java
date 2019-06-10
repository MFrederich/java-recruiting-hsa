package com.concrete.desafio.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler {

    private static final String DEFAULT_ERROR_CODE = "0000";
  public ResponseEntity<ErrorDTO> handlerErrorException(Exception ex) {
    return
        new ResponseEntity<ErrorDTO>(
            new ErrorDTO(DEFAULT_ERROR_CODE, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
