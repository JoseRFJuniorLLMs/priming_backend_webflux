package com.priming.reactive.repository.core;

import com.priming.reactive.model.core.PrimeTargetCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PrimeTargetRepository extends ReactiveMongoRepository<PrimeTargetCollection, String> {

    Flux<PrimeTargetCollection> findByPrime(boolean prime);

    Flux<PrimeTargetCollection> findByPrimeContaining(String prime);

    // Novo método para buscar por palavra-alvo
    Flux<PrimeTargetCollection> findByTargetContaining(String target);
}
