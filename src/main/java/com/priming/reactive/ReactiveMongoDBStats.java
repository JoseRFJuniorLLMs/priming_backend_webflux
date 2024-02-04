package com.priming.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ReactiveMongoDBStats implements CommandLineRunner {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoDBStats.class, args);
    }

    @Override
    public void run(String... args) {
        reactiveMongoTemplate.getCollectionNames()
                .flatMap(collection -> reactiveMongoTemplate.executeCommand("{collStats: '" + collection + "', scale: 1024}")
                        .map(stats -> {
                            double sizeInGB = Double.parseDouble(stats.get("size").toString()) / (1024 * 1024 * 1024);
                            System.out.printf("%s: %.2f GB%n", collection, sizeInGB);
                            return collection;
                        })
                )
                .doFinally(signalType -> {
                    // No need to explicitly close the connection with Spring WebFlux
                })
                .subscribe();
    }
}
