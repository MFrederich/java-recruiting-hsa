package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.utils.JsonUtils.jsonToString;

public class CouponStubs {

  @SuppressWarnings("unchecked")
  public static ResponseEntity<List<Coupon>> expectedApiResponse() throws IOException {
   final List<Coupon> list = new Gson()
           .fromJson(
                   jsonToString("coupons_api_response.json"), new TypeToken<List<Coupon>>() {}.getType());
    return new ResponseEntity<>(
        list,
        HttpStatus.OK);
  }

  public static List<Coupon> expectedResponse() throws IOException {
    return new Gson()
        .fromJson(
            jsonToString("expected_coupons.json"), new TypeToken<List<Coupon>>() {}.getType());
  }
}
