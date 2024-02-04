package com.priming.reactive.controller.core;

import com.priming.reactive.model.core.PrimeTargetCollection;
import com.priming.reactive.service.core.PrimeTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PrimeTargetController {

    @Autowired
    private PrimeTargetService primeTargetService;

    @GetMapping("/prime")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PrimeTargetCollection> getAllPrimeTargets(@RequestParam(required = false) String prime) {
        if (prime == null) {
            return primeTargetService.findAll();
        } else {
            return primeTargetService.findByPrimeContaining(prime);
        }
    }

    @GetMapping("/prime/target")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> getPrimeTargetsByTarget(@RequestParam String prime) {
        return primeTargetService.findSingleTargetByPrime(prime);
    }
}
