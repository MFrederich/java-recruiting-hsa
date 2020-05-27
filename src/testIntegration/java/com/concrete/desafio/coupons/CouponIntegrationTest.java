package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.models.Coupon;
import com.concrete.desafio.coupons.api.CouponRepository;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CouponIntegrationTest {

  private WireMockServer wireMockServer;
  @Autowired private CouponRepository couponRepository;
  private CouponController couponController;

  @BeforeAll
  private void setup() {
    this.wireMockServer = new WireMockServer();
    this.wireMockServer.start();

    final CouponService couponService = new CouponDefaultService(couponRepository);
    couponController = new CouponController(couponService);
  }

  @AfterEach
  void stopWireMockServer() {
    this.wireMockServer.stop();
  }

  @Test
  public void contextLoads() throws Exception {
    wireMockServer.stubFor(
        get(urlEqualTo("/coupons"))
            .willReturn(
                aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBodyFile("")));
    List<Coupon> coupons = couponController.getCoupons().getBody();
  }
}
