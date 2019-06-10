package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.Category;

import java.util.Objects;

public class CategoryResponse extends Category {

  private String iconImageUrl;
  private String smallImageUrl;

  public CategoryResponse(
      final String id,
      final String name,
      final int relevance,
      final String iconImageUrl,
      final String smallImageUrl) {
    super(id, name, relevance);
    this.iconImageUrl = iconImageUrl;
    this.smallImageUrl = smallImageUrl;
  }

  public String getIconImageUrl() {
    return iconImageUrl;
  }

  public String getSmallImageUrl() {
    return smallImageUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    CategoryResponse that = (CategoryResponse) o;
    return Objects.equals(getIconImageUrl(), that.getIconImageUrl())
        && Objects.equals(getSmallImageUrl(), that.getSmallImageUrl());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getIconImageUrl(), getSmallImageUrl());
  }
}
