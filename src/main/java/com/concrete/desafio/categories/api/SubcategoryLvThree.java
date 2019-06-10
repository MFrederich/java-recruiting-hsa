package com.concrete.desafio.categories.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLvThree extends Category {

  private String smallImageUrl;
  private String mediumImageUrl;
  private String largeImageUrl;
  private List<SubcategoryLvFour> subcategories;

  public SubcategoryLvThree() {
  }

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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    SubcategoryLvThree that = (SubcategoryLvThree) o;
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
