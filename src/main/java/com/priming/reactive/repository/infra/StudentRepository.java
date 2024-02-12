package com.priming.reactive.repository.infra;

import com.priming.reactive.model.infra.StudentCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<StudentCollection, String> {

    Flux<StudentCollection> findByCourse(String course);

    Boolean existsByEmail(String email);

    Mono<StudentCollection> findByEmail(String email);



}
