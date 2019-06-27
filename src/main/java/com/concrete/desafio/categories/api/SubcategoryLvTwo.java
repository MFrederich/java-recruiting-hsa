package com.concrete.desafio.categories.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    final SubcategoryLvTwo that = (SubcategoryLvTwo) o;
    return Objects.equals(getIconImageUrl(), that.getIconImageUrl())
        && Objects.equals(getSubcategories(), that.getSubcategories());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getIconImageUrl(), getSubcategories());
  }
}
