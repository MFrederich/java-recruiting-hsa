package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryThree;

import java.util.List;

public interface CategoryService {

  List<CategoryResponse> topFiveCategories();

  List<CategoryResponse> remainingCategories();
}
