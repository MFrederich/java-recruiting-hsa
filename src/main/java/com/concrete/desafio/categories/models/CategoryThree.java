package com.concrete.desafio.categories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryThree extends Category implements Serializable {

  private final List<Subcategory> subcategories;

  public CategoryThree(
      final String id,
      final String name,
      final int relevance,
      final List<Subcategory> subcategories) {
    super(id, name, relevance);
    this.subcategories = subcategories;
  }

  public List<Subcategory> getSubcategories() {
    return subcategories;
  }
}
