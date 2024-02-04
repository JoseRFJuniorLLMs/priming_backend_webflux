// PrimeTargetFraseController.java
package com.priming.reactive.controller;

import com.priming.reactive.model.PrimeTargetFraseCollection;
import com.priming.reactive.service.PrimeTargetFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/prime-target-frase")
public class PrimeTargetFraseController {

    @Autowired
    private PrimeTargetFraseService primeTargetFraseService;

    @GetMapping("/{prime}")
    public Mono<PrimeTargetFraseCollection> findTargetAndTextByPrime(@PathVariable String prime) {
        return primeTargetFraseService.findTargetAndTextByPrime(prime);
    }
}
