// PrimeTargetYoutubeService.java
package com.priming.reactive.service.core;

import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;
import com.priming.reactive.repository.core.PrimeTargetYoutubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PrimeTargetYoutubeService {

    @Autowired
    private PrimeTargetYoutubeRepository primeTargetYoutubeRepository;

    public Mono<PrimeTargetYoutubeCollection> findTargetAndUrlByPrime(String prime) {
        return primeTargetYoutubeRepository.findTargetAndUrlByPrime(prime)
                .collectList()
                .flatMap(results -> {
                    if (results.isEmpty()) {
                        return Mono.error(new RuntimeException("No results found for the keyword: " + prime));
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
