package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/coupon")
public class CouponController {

  private final CouponService couponService;

  @Autowired
  CouponController(final CouponService couponService) {
    this.couponService = couponService;
  }

  @ResponseBody
  @RequestMapping(
      value = "/getCoupons",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  ResponseEntity<List<Coupon>> getCoupons() {
    return couponService.getCoupons();
  }
}
