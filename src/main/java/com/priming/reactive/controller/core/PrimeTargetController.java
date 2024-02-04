package com.priming.reactive.controller.core;

import com.priming.reactive.model.core.PrimeTargetCollection;
import com.priming.reactive.service.core.PrimeTargetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PrimeTargetController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeTargetController.class);

    @Autowired
    private PrimeTargetService primeTargetService;

    @GetMapping("/prime")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PrimeTargetCollection> getAllPrimeTargets(@RequestParam(required = false) String prime) {
        logger.info("Request received to get all prime targets.");

        Flux<PrimeTargetCollection> result;

        if (prime == null) {
            result = primeTargetService.findAll();
        } else {
            result = primeTargetService.findByPrimeContaining(prime);
        }

        logger.info("Returning prime targets: {}", result);
        return result;
    }

    @GetMapping("/prime/target/{prime}")
    public Mono<ResponseEntity<String>> getPrimeTargetsByTarget(@PathVariable String prime) {
        logger.info("Request received to get prime targets by target for prime: {}", prime);

        return primeTargetService.findSingleTargetByPrime(prime)
                .map(result -> {
                    if (result != null) {
                        logger.info("Returning prime target: {}", result);
                        return ResponseEntity.ok(result);
                    } else {
                        logger.warn("No prime target found for prime: {}", prime);
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prime target not found for prime: " + prime);
                    }
                })
                .doOnError(throwable -> {
                    logger.error("Error while processing request for prime: {}", prime, throwable);
                })
                .onErrorResume(throwable -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error")));
    }
}
