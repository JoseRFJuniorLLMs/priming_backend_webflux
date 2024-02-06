package com.priming.reactive.controller.core;

import com.priming.reactive.service.core.PrimeTargetYoutubeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/youtube")
public class PrimeTargetYoutubeController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeTargetYoutubeController.class);

    @Autowired
    private PrimeTargetYoutubeService primeTargetYoutubeService;

    @GetMapping("/{prime}")
    public Mono<ResponseEntity<?>> findTargetAndUrlByPrime(@PathVariable String prime) {
        logger.info("Request received to find target and text for prime: {}", prime);

        return primeTargetYoutubeService.findTargetAndUrlByPrime(prime)
                .map(result -> {
                    logger.info("Returning target and text for prime: {}", prime);
                    return result != null
                            ? ResponseEntity.ok(result)
                            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                })
                .doOnError(error -> logger.error("Error while processing request for prime: {}", prime, error))
                .onErrorResume(error -> {
                    logger.error("Internal server error for prime: {}", prime, error);
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
                });
    }
}
