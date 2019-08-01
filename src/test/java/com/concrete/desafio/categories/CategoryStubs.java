package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryThree;
import com.concrete.desafio.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.concrete.desafio.utils.JsonUtils.jsonToString;

public class CategoryStubs {

  public static ResponseEntity<CategoryThree> expectedApiResponse() throws IOException {
    return new ResponseEntity<>(
        (CategoryThree)
            JsonUtils.jsonParser(
                jsonToString("categories_complete.json"),
                new TypeToken<CategoryThree>() {}.getType()),
        HttpStatus.OK);
  }

  public static List<CategoryResponse> expectedTopFiveOutput() throws IOException {
    return (List<CategoryResponse>)
        JsonUtils.jsonParser(
            jsonToString("expected_response.json"),
            new TypeToken<ArrayList<CategoryResponse>>() {}.getType());
  }

  public static List<CategoryResponse> expectedRemainingOutput() throws IOException {
    return (List<CategoryResponse>)
        JsonUtils.jsonParser(
            jsonToString("expected_remaining_categories.json"),
            new TypeToken<ArrayList<CategoryResponse>>() {}.getType());
  }

  public static ResponseEntity<CategoryThree> subCategoryNullOutput() throws IOException {
    return new ResponseEntity<>(
        (CategoryThree)
            JsonUtils.jsonParser(
                jsonToString("categories_null.json"), new TypeToken<CategoryThree>() {}.getType()),
        HttpStatus.OK);
  }

  public static ResponseEntity<CategoryThree> subCategoryMobileMarketNotFound() throws IOException {
    return new ResponseEntity<>(
        (CategoryThree)
            JsonUtils.jsonParser(
                jsonToString("subcategories_null.json"),
                new TypeToken<CategoryThree>() {}.getType()),
        HttpStatus.OK);
  }

  public static ResponseEntity<CategoryThree> categoryWithOnlyFourSubcategories()
      throws IOException {
    return new ResponseEntity<>(
        (CategoryThree)
            JsonUtils.jsonParser(
                jsonToString("only_four_subcategories.json"),
                new TypeToken<CategoryThree>() {}.getType()),
        HttpStatus.OK);
  }
}
