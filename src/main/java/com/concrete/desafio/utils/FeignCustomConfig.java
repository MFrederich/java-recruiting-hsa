package com.concrete.desafio.utils;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;

public class FeignCustomConfig {

  @Bean
  public Decoder feignDecoder() {
    return new ResponseEntityDecoder(new GsonDecoder());
  }
}
