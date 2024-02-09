package com.priming.reactive.repository.infra;

import com.priming.reactive.model.infra.CourseCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<CourseCollection, String> {

    Flux<CourseCollection> findByCategory(String category);

    Flux<CourseCollection> findByName(String name);

    // Adicione os métodos para as outras consultas aqui
    Flux<CourseCollection> findByDuration(int duration);

    Flux<CourseCollection> findByLevel(String level);

    Flux<CourseCollection> findByPriceLessThan(double price);

    Flux<CourseCollection> findByRatingGreaterThanEqual(double rating);

}
