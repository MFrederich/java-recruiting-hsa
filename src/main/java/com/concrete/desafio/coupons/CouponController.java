package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "Coupon management")
@RequestMapping("/coupon")
public class CouponController {

  private final CouponService couponService;

  @Autowired
  CouponController(final CouponService couponService) {
    this.couponService = couponService;
  }

  @ResponseBody
  @ApiOperation(value = "List coupon")
  @RequestMapping(
      value = "/getCoupons",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  ResponseEntity<List<Coupon>> getCoupons() {
    return couponService.getCoupons();
  }
}
