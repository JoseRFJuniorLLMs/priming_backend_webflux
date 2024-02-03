package com.priming.reactive.controller;

import com.priming.reactive.model.PrimeTargetCollection;
import com.priming.reactive.service.PrimeTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PrimeTargetController {

    @Autowired
    PrimeTargetService primeTargetService;


    @GetMapping("/prime")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PrimeTargetCollection> getAllTprime(@RequestParam(required = false) String prime) {
        if (prime == null)
            return primeTargetService.findAll();
        else
            return primeTargetService.findByPrime(prime);
    }
}
