package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.concrete.desafio.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.concrete.desafio.utils.JsonUtils.jsonToString;

public class CouponStubs {

  public static ResponseEntity<List<Coupon>> expectedApiResponse() throws IOException {
    ResponseEntity response =
        new ResponseEntity<>(
            (List<Coupon>)
                JsonUtils.jsonParser(
                    jsonToString("coupons_api_response.json"),
                    new TypeToken<ArrayList<Coupon>>() {}.getType()),
            HttpStatus.OK);

    return response;
  }

  public static List<Coupon> expectedResponse() throws IOException {
    return (List<Coupon>)
        JsonUtils.jsonParser(
            jsonToString("expected_coupons.json"), new TypeToken<ArrayList<Coupon>>() {}.getType());
  }
}
