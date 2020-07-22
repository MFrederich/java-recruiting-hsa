package com.concrete.desafio.categories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLvFour extends Category implements Serializable {

  private static final long serialVersionUID = -3755866992529556567L;

  public SubcategoryLvFour(final String id, final String name, final int relevance) {
    super(id, name, relevance);
  }
}
