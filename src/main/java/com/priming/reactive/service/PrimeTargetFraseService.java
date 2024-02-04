// PrimeTargetFraseService.java
package com.priming.reactive.service;

import com.priming.reactive.model.PrimeTargetFraseCollection;
import com.priming.reactive.repository.PrimeTargetFraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PrimeTargetFraseService {

    @Autowired
    private PrimeTargetFraseRepository primeTargetFraseRepository;

    public Mono<PrimeTargetFraseCollection> findTargetAndTextByPrime(String prime) {
        return primeTargetFraseRepository.findTargetAndTextByPrime(prime)
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
