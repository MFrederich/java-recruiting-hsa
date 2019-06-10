package com.concrete.desafio.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
public class CategoryController {

  private CategoryService categoryService;

  @Autowired
  public CategoryController(final CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @ResponseBody
  @RequestMapping(
      value = "/getTopCategories",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public List<CategoryResponse> getTopCategorie() {
    return categoryService.topFiveCategories();
  }

  @ResponseBody
  @RequestMapping(
          value = "/getRemainingCategories",
          produces = MediaType.APPLICATION_JSON_VALUE,
          method = RequestMethod.GET)
  public List<CategoryResponse> getRemainingCategorie() {
    return categoryService.remainingCategories();
  }

}
