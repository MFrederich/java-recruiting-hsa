package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.categories.CategoryStubs.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoryControllerTest {

  private CategoryRepository categoryRepository;
  private CategoryService categoryService;
  private CategoryController categoryController;

  @BeforeAll
  public void setup() {
    categoryRepository = Mockito.mock(CategoryRepository.class);
    categoryService = new CategoryDefaultService(categoryRepository);
    categoryController = new CategoryController(categoryService);
  }

  @Test
  public void itShouldReturn_expectedTopFiveOutput() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(expectedApiResponse());
    final List<CategoryResponse> categoryTopFiveList =
        categoryController.getTopCategories().getBody();
    final List<CategoryResponse> expected = expectedTopFiveOutput();

    assertEquals(categoryTopFiveList, expected);
  }

  @Test
  public void itShouldReturnExpectedTopFiveOutput_whenHaveFourCategories() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(categoryWithOnlyFourSubcategories());
    final List<CategoryResponse> categoryTopFiveList =
        categoryController.getTopCategories().getBody();
    final List<CategoryResponse> categoryRemainingList =
        categoryController.getRemainingCategories().getBody();

    assertEquals(categoryTopFiveList.size(), 4);
    assertEquals(categoryRemainingList.size(), 0);
  }

  @Test
  public void itShouldReturn_expectedRemainingOutput() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(expectedApiResponse());
    final List<CategoryResponse> categoryRemainingList =
        categoryController.getRemainingCategories().getBody();
    final List<CategoryResponse> expected = expectedRemainingOutput();

    assertEquals(categoryRemainingList, expected);
  }

  @Test()
  public void itShouldReturnIllegalArgumentException_whenSubcategoriesIsNull() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(subCategoryNullOutput());
    Assertions.assertThrows(IllegalArgumentException.class, categoryController::getTopCategories);
  }

  @Test()
  public void itShouldReturnIllegalArgumentException_whenMobileMarketNotFound() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(subCategoryMobileMarketNotFound());
    Assertions.assertThrows(IllegalArgumentException.class, categoryController::getTopCategories);
  }
}
