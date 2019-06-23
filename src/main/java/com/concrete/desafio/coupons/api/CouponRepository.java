package com.concrete.desafio.coupons.api;

import com.concrete.desafio.utils.FeignCustomerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "${feign.client.coupons}", name = "coupons",configuration = FeignCustomerConfig.class)
public interface CouponRepository {

  @RequestMapping(method = RequestMethod.GET, value = "/coupons")
  ResponseEntity<List<Coupon>> fetchCoupons();
}
