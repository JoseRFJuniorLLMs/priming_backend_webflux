package com.priming.reactive.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.priming.reactive.service.core.PrimeTargetFraseService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/phrases")
public class PrimeTargetFraseController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeTargetFraseController.class);

    private final PrimeTargetFraseService primeTargetFraseService;

    public PrimeTargetFraseController(PrimeTargetFraseService primeTargetFraseService) {
        this.primeTargetFraseService = primeTargetFraseService;
    }

    @GetMapping("/{prime}")
    public Mono<ResponseEntity<?>> findTargetAndTextByPrime(@PathVariable String prime) {
        logger.info("Request received to find target and text for prime: {}", prime);

        return primeTargetFraseService.findTargetAndFraseByPrime(prime)
                .map(result -> {
                    if (result != null) {
                        logger.info("Returning target and text for prime: {}", prime);
                        return ResponseEntity.ok(result);
                    } else {
                        logger.warn("No target and text found for prime: {}", prime);
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                    }
                });
    }
}
