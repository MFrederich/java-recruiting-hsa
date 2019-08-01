package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.Category;

import java.util.List;
import java.util.Objects;

public class CategoryResponse extends Category {

  private final String iconImageUrl;
  private final List<SubCategoryResponse> subcategories;

  public CategoryResponse(
      final String id,
      final String name,
      final int relevance,
      final String iconImageUrl,
      final List<SubCategoryResponse> subcategories) {
    super(id, name, relevance);
    this.iconImageUrl = iconImageUrl;
    this.subcategories = subcategories;
  }

  public String getIconImageUrl() {
    return iconImageUrl;
  }

  public List<SubCategoryResponse> getSubcategories() {
    return subcategories;
  }

  @Override
  public boolean equals(final Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    final CategoryResponse that = (CategoryResponse) o;
    return Objects.equals(getIconImageUrl(), that.getIconImageUrl())
        && Objects.equals(getSubcategories(), that.getSubcategories());
  }
}
