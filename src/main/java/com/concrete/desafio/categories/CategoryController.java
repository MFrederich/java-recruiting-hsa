package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryRepository;
import com.concrete.desafio.categories.api.CategoryThree;
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
      value = "/getTopCategorie",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public List<CategoryResponse> getTopCategorie() {
    return categoryService.topCategories();
  }
}
