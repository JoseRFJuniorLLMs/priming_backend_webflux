package com.priming.reactive.repository.core;

import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PrimeTargetYoutubeRepository extends ReactiveMongoRepository<PrimeTargetYoutubeCollection, String> {

    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'prime' : 1, 'target' : 1, 'url' : 1")
    Flux<PrimeTargetYoutubeCollection> findTargetAndUrlByPrime(String prime);

}
