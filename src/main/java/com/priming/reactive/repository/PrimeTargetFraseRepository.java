// PrimeTargetFraseRepository.java
package com.priming.reactive.repository;

import com.priming.reactive.model.PrimeTargetFraseCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrimeTargetFraseRepository extends ReactiveMongoRepository<PrimeTargetFraseCollection, String> {
    Mono<PrimeTargetFraseCollection> findByPrime(String prime);

    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'prime' : 1, 'target' : 1, 'text' : 1}")
    Flux<PrimeTargetFraseCollection> findTargetAndTextByPrime(String prime);
}