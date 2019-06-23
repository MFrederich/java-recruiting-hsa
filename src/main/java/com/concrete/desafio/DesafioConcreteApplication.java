package com.concrete.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class DesafioConcreteApplication {

  public static void main(String[] args) {
    SpringApplication.run(DesafioConcreteApplication.class, args);
  }
}
