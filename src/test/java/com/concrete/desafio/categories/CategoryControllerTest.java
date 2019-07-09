package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryRepository;
import com.concrete.desafio.utils.ErrorDTO;
import com.concrete.desafio.utils.ErrorHandlerController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.categories.CategoryStubs.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

  @Mock private CategoryRepository categoryRepository;
  private CategoryService categoryService;
  private CategoryController categoryController;
  private ErrorHandlerController errorHandler;

  @Before
  public void setup() {
    errorHandler = new ErrorHandlerController();
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

  @Test(expected = IllegalArgumentException.class)
  public void itShouldReturnIllegalArgumentException_whenSubcategoriesIsNull() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(subCategoryNullOutput());
    final ResponseEntity responseEntity = categoryController.getTopCategories();
    final ErrorDTO expectedError = new ErrorDTO("0000", "SubCategories can not be null");
    Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
    assertEquals(responseEntity.getBody(), expectedError);
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldReturnIllegalArgumentException_whenMobileMarketNotFound() throws IOException {
    when(categoryRepository.fetchCategoryThree()).thenReturn(subCategoryMobileMarketNotFound());
    final ResponseEntity responseEntity = categoryController.getTopCategories();
    final ErrorDTO expectedError = new ErrorDTO("0000", "Mobile market category not found");
    Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
    assertEquals(responseEntity.getBody(), expectedError);
  }

  @Test
  public void itShouldReturnException_whenRequestThrowException() {
    final Exception failure = new Exception("not found");
    final ResponseEntity responseEntity = errorHandler.handlerErrorException(failure);
    final ErrorDTO expectedError = new ErrorDTO("0000", "not found");
    Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
    assertEquals(responseEntity.getBody(), expectedError);
  }
}
