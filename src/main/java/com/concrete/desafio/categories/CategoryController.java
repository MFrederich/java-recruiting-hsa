package com.concrete.desafio.categories;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
public class CategoryController {

  @ResponseBody
  @RequestMapping(
      value = "/getTopCategorie",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public void getTopCategorie() {}
}
