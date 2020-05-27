package com.concrete.desafio.categories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category implements Serializable {

  private final String id;
  private final String name;
  private final int relevance;

  public Category(final String id, final String name, final int relevance) {
    this.id = id;
    this.name = name;
    this.relevance = relevance;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getRelevance() {
    return relevance;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Category that = (Category) o;
    return getRelevance() == that.getRelevance()
        && Objects.equals(getId(), that.getId())
        && Objects.equals(getName(), that.getName());
  }
}
