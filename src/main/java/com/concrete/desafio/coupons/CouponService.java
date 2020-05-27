package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.models.Coupon;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CouponService {

    ResponseEntity<List<Coupon>> getCoupons();
}
