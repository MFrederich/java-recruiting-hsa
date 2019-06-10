package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryRepository;
import com.concrete.desafio.categories.api.CategoryThree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestController
public class CategoryController {

  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryController(final CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @ResponseBody
  @RequestMapping(
      value = "/getTopCategorie",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public CategoryThree getTopCategorie() {
    CategoryThree categoryThree = categoryRepository.getCategoryThree().getBody();
    return categoryThree;
  }
}
