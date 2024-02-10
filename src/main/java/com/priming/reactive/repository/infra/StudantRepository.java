package com.priming.reactive.repository.infra;

import com.priming.reactive.model.infra.StudantCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudantRepository extends ReactiveMongoRepository<StudantCollection, String> {

    Flux<StudantCollection> findByCourse(String course);


}
