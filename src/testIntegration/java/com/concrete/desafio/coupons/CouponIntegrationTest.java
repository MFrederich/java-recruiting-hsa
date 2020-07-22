package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.CouponRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.concrete.desafio.coupons.CouponStubs.expectedApiResponse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CouponIntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    protected WebApplicationContext wac;
    private CouponService couponService;

    @Before
    public void setup(){
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        couponService = Mockito.mock(CouponDefaultService.class);

    }

    @Test
    public void itShouldReturnCoupons_whenApiResponse200() throws Exception{
        when(couponService.getCoupons()).thenReturn(expectedApiResponse());
        mvc.perform(get("/coupon")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
