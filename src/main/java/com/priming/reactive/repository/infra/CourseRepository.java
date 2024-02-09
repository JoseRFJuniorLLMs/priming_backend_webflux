package com.priming.reactive.repository.infra;

import com.priming.reactive.model.infra.AlunoCollection;
import com.priming.reactive.model.infra.CourseCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<CourseCollection, String> {

    Flux<CourseCollection> findByCategory(String category);

    Flux<CourseCollection> findByName(String name);


}
