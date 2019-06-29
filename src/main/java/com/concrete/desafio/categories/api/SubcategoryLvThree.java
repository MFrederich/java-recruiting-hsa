package com.concrete.desafio.categories.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLvThree extends Category implements Serializable {

  private final String smallImageUrl;
  private final String mediumImageUrl;
  private final String largeImageUrl;
  private final List<SubcategoryLvFour> subcategories;

  public SubcategoryLvThree(
      final String id,
      final String name,
      final int relevance,
      final String smallImageUrl,
      final String mediumImageUrl,
      final String largeImageUrl,
      final List<SubcategoryLvFour> subcategoryLvFour) {
    super(id, name, relevance);
    this.smallImageUrl = smallImageUrl;
    this.mediumImageUrl = mediumImageUrl;
    this.largeImageUrl = largeImageUrl;
    this.subcategories = subcategoryLvFour;
  }

  public String getSmallImageUrl() {
    return smallImageUrl;
  }

  public String getMediumImageUrl() {
    return mediumImageUrl;
  }

  public String getLargeImageUrl() {
    return largeImageUrl;
  }

  public List<SubcategoryLvFour> getSubcategories() {
    return subcategories;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    final SubcategoryLvThree that = (SubcategoryLvThree) o;
    return Objects.equals(getSmallImageUrl(), that.getSmallImageUrl())
        && Objects.equals(getMediumImageUrl(), that.getMediumImageUrl())
        && Objects.equals(getLargeImageUrl(), that.getLargeImageUrl())
        && Objects.equals(getSubcategories(), that.getSubcategories());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getSmallImageUrl(),
        getMediumImageUrl(),
        getLargeImageUrl(),
        getSubcategories());
  }
}
