package com.concrete.desafio.categories.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLvTwo extends Category implements Serializable {

  private final String iconImageUrl;
  private final List<SubcategoryLvThree> subcategories;

  public SubcategoryLvTwo(
      final String id,
      final String name,
      final int relevance,
      final String iconImageUrl,
      final List<SubcategoryLvThree> subcategoryLvThree) {
    super(id, name, relevance);
    this.iconImageUrl = iconImageUrl;
    this.subcategories = subcategoryLvThree;
  }

  public String getIconImageUrl() {
    return iconImageUrl;
  }

  public List<SubcategoryLvThree> getSubcategories() {
    return subcategories;
  }
}
