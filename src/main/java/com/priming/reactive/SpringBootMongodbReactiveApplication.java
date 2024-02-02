package com.priming.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@ComponentScan(basePackages = "com.priming.reactive")
public class SpringBootMongodbReactiveApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMongodbReactiveApplication.class, args);
  }

}
