package com.concrete.desafio.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

  private CategoryService categoryService;

  @Autowired
  CategoryController(final CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @ResponseBody
  @RequestMapping(
      value = "/getTopCategories",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  ResponseEntity<List<CategoryResponse>> getTopCategories() {
    return categoryService.topFiveCategories();
  }

  @ResponseBody
  @RequestMapping(
      value = "/getRemainingCategories",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  ResponseEntity<List<CategoryResponse>> getRemainingCategories() {

    return categoryService.remainingCategories();
  }
}
