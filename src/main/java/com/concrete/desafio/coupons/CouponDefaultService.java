package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.concrete.desafio.coupons.api.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponDefaultService implements CouponService {

  private final CouponRepository couponRepository;

  @Autowired
  public CouponDefaultService(final CouponRepository couponRepository) {
    this.couponRepository = couponRepository;
  }

  @Override
  public ResponseEntity<List<Coupon>> getCoupons() {
    return new ResponseEntity<>(
        filterExpiredCoupon(couponRepository.fetchCoupons().getBody()), HttpStatus.OK);
  }

  private List<Coupon> filterExpiredCoupon(final List<Coupon> couponList) {
    if (couponList == null) {
      return Collections.emptyList();
    }
    return couponList.stream()
        .filter(coupon -> isExpired(coupon.getExpiresAt()))
        .collect(Collectors.toList());
  }

  private boolean isExpired(final String expireDate) {
    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    final String strDateNow = formatter.format(new Date());
    try {
      return mapStringToDate(expireDate, formatter).after(mapStringToDate(strDateNow, formatter));
    } catch (final ParseException e) {

      e.printStackTrace();
    }
    return false;
  }

  private Date mapStringToDate(final String stringDate, final SimpleDateFormat formatter) throws ParseException {
    return formatter.parse(stringDate);
  }
}
