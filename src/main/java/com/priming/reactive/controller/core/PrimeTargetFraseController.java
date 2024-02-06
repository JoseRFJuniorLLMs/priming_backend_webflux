// PrimeTargetFraseController.java
package com.priming.reactive.controller.core;

import com.priming.reactive.model.core.PrimeTargetFraseCollection;
import com.priming.reactive.service.core.PrimeTargetFraseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/frase")
public class PrimeTargetFraseController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeTargetFraseController.class);

    @Autowired
    private PrimeTargetFraseService primeTargetFraseService;

    @GetMapping("/{prime}")
    public Mono<ResponseEntity<PrimeTargetFraseCollection>> findTargetAndTextByPrime(@PathVariable String prime) {
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
