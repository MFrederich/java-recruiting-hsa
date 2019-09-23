package com.concrete.desafio.categories;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "Category management")
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  CategoryController(final CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @ResponseBody
  @ApiOperation(value = "Get top five categories")
  @GetMapping(value = "/getTopCategories", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<CategoryResponse>> getTopCategories() {
    return categoryService.topFiveCategories();
  }

  @ResponseBody
  @ApiOperation(value = "Get remaining categories")
  @GetMapping(value = "/getRemainingCategories", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<CategoryResponse>> getRemainingCategories() {

    return categoryService.remainingCategories();
  }
}
