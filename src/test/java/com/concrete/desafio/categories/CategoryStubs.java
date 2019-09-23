package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryThree;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.utils.JsonUtils.jsonToString;

public class CategoryStubs {

  public static ResponseEntity<CategoryThree> expectedApiResponse() throws IOException {
    return new ResponseEntity<>(
        new Gson().fromJson(jsonToString("categories_complete.json"), CategoryThree.class),
        HttpStatus.OK);
  }

  public static List<CategoryResponse> expectedTopFiveOutput() throws IOException {
    return new Gson()
        .fromJson(
            jsonToString("expected_response.json"),
            new TypeToken<List<CategoryResponse>>() {}.getType());
  }

  public static List<CategoryResponse> expectedRemainingOutput() throws IOException {
    return new Gson()
        .fromJson(
            jsonToString("expected_remaining_categories.json"),
            new TypeToken<List<CategoryResponse>>() {}.getType());
  }

  public static ResponseEntity<CategoryThree> subCategoryNullOutput() throws IOException {
    return new ResponseEntity<>(
        new Gson().fromJson(jsonToString("subcategories_null.json"), CategoryThree.class),
        HttpStatus.OK);
  }

  public static ResponseEntity<CategoryThree> subCategoryMobileMarketNotFound() throws IOException {
    return new ResponseEntity<>(
        new Gson().fromJson(jsonToString("subcategories_null.json"), CategoryThree.class),
        HttpStatus.OK);
  }

  public static ResponseEntity<CategoryThree> categoryWithOnlyFourSubcategories()
      throws IOException {
    return new ResponseEntity<>(
        new Gson().fromJson(jsonToString("only_four_subcategories.json"), CategoryThree.class),
        HttpStatus.OK);
  }
}
