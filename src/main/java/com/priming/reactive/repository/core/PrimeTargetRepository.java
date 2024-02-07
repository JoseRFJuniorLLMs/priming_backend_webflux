package com.priming.reactive.repository.core;

import com.priming.reactive.model.core.PrimeTargetCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PrimeTargetRepository extends ReactiveMongoRepository<PrimeTargetCollection, String> {

    Flux<PrimeTargetCollection> findByPrime(boolean prime);

    @Query(value = "{ 'prime' : ?0 }", fields = "{ 'prime' : 1, 'target' : 1 }")
    Flux<PrimeTargetCollection> findByPrimeContaining(String prime);

}
