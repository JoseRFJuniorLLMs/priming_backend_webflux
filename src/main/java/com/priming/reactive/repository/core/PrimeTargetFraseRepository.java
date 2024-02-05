// PrimeTargetFraseRepository.java
package com.priming.reactive.repository.core;

import com.priming.reactive.model.core.PrimeTargetFraseCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrimeTargetFraseRepository extends ReactiveMongoRepository<PrimeTargetFraseCollection, String> {
    Mono<PrimeTargetFraseCollection> findByPrime(String prime);

    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'prime' : 1, 'target' : 1, 'url' : 1, 'frase' : 1}")
    Flux<PrimeTargetFraseCollection> findTargetAndTextByPrime(String prime);
}
