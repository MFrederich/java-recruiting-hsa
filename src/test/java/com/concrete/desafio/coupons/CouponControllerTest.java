package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.concrete.desafio.coupons.api.CouponRepository;
import com.concrete.desafio.utils.ErrorDTO;
import com.concrete.desafio.utils.ErrorHandlerController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.coupons.CouponStubs.expectedApiResponse;
import static com.concrete.desafio.coupons.CouponStubs.expectedResponse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CouponControllerTest {

  private CouponRepository couponRepository;
  private CouponService couponService;
  private CouponController couponController;

  @BeforeAll
  public void setup() {
    couponRepository = Mockito.mock(CouponRepository.class);
    couponService = new CouponDefaultService(couponRepository);
    couponController = new CouponController(couponService);
  }

  @Test
  public void itShouldReturnExpectedResponse_whenApiIsOk() throws IOException {
    when(couponRepository.fetchCoupons()).thenReturn(expectedApiResponse());

    final List<Coupon> coupons = couponController.getCoupons().getBody();
    final List<Coupon> expected = expectedResponse();

    assertEquals(coupons, expected);
  }

}
