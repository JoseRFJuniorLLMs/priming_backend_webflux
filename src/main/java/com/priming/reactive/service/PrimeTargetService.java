package com.priming.reactive.service;

import com.priming.reactive.model.PrimeTargetCollection;
import com.priming.reactive.repository.PrimeTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrimeTargetService {

    @Autowired
    private PrimeTargetRepository primeTargetRepository;

    public Flux<PrimeTargetCollection> findAll() {
        return primeTargetRepository.findAll();
    }

    public Flux<PrimeTargetCollection> findByPrimeContaining(String target) {
        return primeTargetRepository.findByPrimeContaining(target);
    }
    public Mono<String> findSingleTargetByPrime(String prime) {
        return primeTargetRepository.findByPrimeContaining(prime)
                .map(PrimeTargetCollection::getTarget)
                .next(); // Use next() para obter o primeiro item como Mono
    }


}
