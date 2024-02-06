package com.priming.reactive.repository.core;

import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrimeTargetYoutubeRepository extends ReactiveMongoRepository<PrimeTargetYoutubeCollection, String> {

    Mono<PrimeTargetYoutubeCollection> findByPrime(String prime);
    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'prime' : 1, 'target' : 1, 'url' : 1")
    Flux<PrimeTargetYoutubeCollection> findTargetAndUrlByPrime(String prime);

}
