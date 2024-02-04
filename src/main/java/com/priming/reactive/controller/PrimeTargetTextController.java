// PrimeTargetTextController.java
package com.priming.reactive.controller;

import com.priming.reactive.model.PrimeTargetTextCollection;
import com.priming.reactive.service.PrimeTargetTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/prime-target")
public class PrimeTargetTextController {

    @Autowired
    private PrimeTargetTextService primeTargetTextService;

    @GetMapping("/{prime}")
    public Mono<PrimeTargetTextCollection> findTargetAndTextByPrime(@PathVariable String prime) {
        return primeTargetTextService.findTargetAndTextByPrime(prime);
    }
}
