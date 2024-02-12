package com.priming.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

@EnableWebFlux
@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(basePackages = "com.priming.reactive")
public class SpringBootMongodbReactiveApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMongodbReactiveApplication.class, args);
  }


}
