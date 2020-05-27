package com.concrete.desafio.coupons.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coupon implements Serializable {

  private final String id;
  private final String description;
  private final String seller;
  private final String image;
  private final String expiresAt;

  public Coupon(
      final String id,
      final String description,
      final String seller,
      final String image,
      final String expiresAt) {
    this.id = id;
    this.description = description;
    this.seller = seller;
    this.image = image;
    this.expiresAt = expiresAt;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getSeller() {
    return seller;
  }

  public String getImage() {
    return image;
  }

  public String getExpiresAt() {
    return expiresAt;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Coupon coupon = (Coupon) o;
    return Objects.equals(getId(), coupon.getId())
        && Objects.equals(getDescription(), coupon.getDescription())
        && Objects.equals(getSeller(), coupon.getSeller())
        && Objects.equals(getImage(), coupon.getImage())
        && Objects.equals(getExpiresAt(), coupon.getExpiresAt());
  }
}
