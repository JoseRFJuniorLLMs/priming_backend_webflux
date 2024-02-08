package com.priming.reactive.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.priming.reactive.service.core.PrimeTargetPhraseService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PrimeTargetPhraseController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeTargetPhraseController.class);

    @Autowired
    private PrimeTargetPhraseService primeTargetPhraseService;

    @GetMapping("/phrase/{prime}")
    public Mono<ResponseEntity<?>> findTargetAndTextByPrime(@PathVariable String prime) {
        logger.info("Request received to find target and text for prime: {}", prime);

        return primeTargetPhraseService.findTargetAndPhraseByPrime(prime)
                .map(result -> {
                    if (result != null) {
                        logger.info("Returning target and text for prime: {}", prime);
                        return ResponseEntity.ok(result);
                    } else {
                        logger.warn("No target and text found for prime: {}", prime);
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                    }
                })
                .doOnError(throwable -> {
                    logger.error("Error while processing request for prime: {}", prime, throwable);
                })
                .onErrorResume(throwable -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)));
    }
}
