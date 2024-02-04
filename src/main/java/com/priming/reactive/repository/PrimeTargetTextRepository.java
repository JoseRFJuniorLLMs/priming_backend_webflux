// PrimeTargetTextRepository.java
package com.priming.reactive.repository;

import com.priming.reactive.model.PrimeTargetTextCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrimeTargetTextRepository extends ReactiveMongoRepository<PrimeTargetTextCollection, String> {
    Mono<PrimeTargetTextCollection> findByPrime(String prime);

    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'target' : 1, 'text' : 1}")
    Flux<PrimeTargetTextCollection> findTargetAndTextByPrime(String prime);
}
