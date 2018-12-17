package com.citylife.function.bff.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FunctionApplication {
  public static void main(String[] args) {
    SpringApplication.run(FunctionApplication.class, args);
  }

}
