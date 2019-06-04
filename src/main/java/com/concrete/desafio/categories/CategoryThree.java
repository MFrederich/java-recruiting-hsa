package com.concrete.desafio.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryThree extends Category {

  private List<Subcategory> subcategories;

  public CategoryThree() {}

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    CategoryThree that = (CategoryThree) o;
    return Objects.equals(getSubcategories(), that.getSubcategories());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getSubcategories());
  }
}