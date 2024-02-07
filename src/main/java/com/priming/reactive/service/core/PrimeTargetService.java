package com.priming.reactive.service.core;

import com.priming.reactive.model.core.PrimeTargetCollection;
import com.priming.reactive.repository.core.PrimeTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrimeTargetService {

    @Autowired
    private PrimeTargetRepository primeTargetRepository;

    public Mono<PrimeTargetCollection> findSingleTargetByPrime(String prime) {
        return primeTargetRepository.findByPrimeContaining(prime)
                .collectList()
                .flatMap(results -> {
                    if (results.isEmpty()) {
                        return Mono.error(new RuntimeException("Nenhum resultado encontrado para a palavra-chave: " + prime));
                    } else if (results.size() > 1) {
                        // Handle the case of multiple results as needed
                        // For example, returning the first result in this example
                        return Mono.just(results.get(0));
                    } else {
                        return Mono.just(results.get(0));
                    }
                });
    }
}
