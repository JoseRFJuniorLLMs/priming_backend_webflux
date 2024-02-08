// PrimeTargetFraseRepository.java
package com.priming.reactive.repository.core;

import com.priming.reactive.model.core.PrimeTargetPhraseCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrimeTargetPhraseRepository extends ReactiveMongoRepository<PrimeTargetPhraseCollection, String> {
    Mono<PrimeTargetPhraseCollection> findByPrime(String prime);

    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'prime' : 1, 'target' : 1, 'url' : 1, 'phrase' : 1, 'imagem' : 1}")
    Flux<PrimeTargetPhraseCollection> findTargetAndPhraseByPrime(String prime);
}
