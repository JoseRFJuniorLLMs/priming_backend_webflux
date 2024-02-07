package com.priming.reactive.repository.infra;

import com.priming.reactive.model.infra.ClassroomCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ClassroomRepository extends ReactiveMongoRepository<ClassroomCollection, String> {

    @Query(value = "{ 'alunoId' : ?0 }", fields = "{ 'alunoId' : 1, 'curso' : 1, 'modulo' : 1, 'prime' : 1, 'target' : 1, 'phrases' : 1, 'urlAudio' : 1, 'urlImagem' : 1, 'urlVideo' : 1, 'text' : 1 }")
    Flux<ClassroomCollection> findByAlunoId(String alunoId);
}
