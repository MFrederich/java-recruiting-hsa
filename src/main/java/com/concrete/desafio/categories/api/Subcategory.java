package com.concrete.desafio.categories.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subcategory extends Category {

  private final List<SubcategoryLvTwo> subcategories;

  public Subcategory(
      final String id,
      final String name,
      final int relevance,
      final List<SubcategoryLvTwo> subcategories) {
    super(id, name, relevance);
    this.subcategories = subcategories;
  }

  public List<SubcategoryLvTwo> getSubcategories() {
    return subcategories;
  }
}
