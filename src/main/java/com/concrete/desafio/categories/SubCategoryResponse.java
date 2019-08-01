package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.Category;
import com.concrete.desafio.categories.api.SubcategoryLvFour;

import java.util.List;
import java.util.Objects;

public class SubCategoryResponse extends Category {

  private final String smallImageUrl;
  private final List<SubcategoryLvFour> subcategories;

  public SubCategoryResponse(
      final String id,
      final String name,
      final int relevance,
      final String smallImageUrl,
      final List<SubcategoryLvFour> subcategories) {
    super(id, name, relevance);
    this.smallImageUrl = smallImageUrl;
    this.subcategories = subcategories;
  }

  public String getSmallImageUrl() {
    return smallImageUrl;
  }

  public List<SubcategoryLvFour> getSubcategories() {
    return subcategories;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    final SubCategoryResponse that = (SubCategoryResponse) o;
    return Objects.equals(getSmallImageUrl(), that.getSmallImageUrl())
        && Objects.equals(getSubcategories(), that.getSubcategories());
  }

}
