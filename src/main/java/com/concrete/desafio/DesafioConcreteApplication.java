package com.concrete.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
@EnableCircuitBreaker
public class DesafioConcreteApplication {

  public static void main(final String[] args) {
    SpringApplication.run(DesafioConcreteApplication.class, args);
  }
}
