package com.priming.reactive.repository.infra;

import com.priming.reactive.model.infra.AlunoCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AlunoRepository extends ReactiveMongoRepository<AlunoCollection, String> {

    Flux<AlunoCollection> findByCurso(String curso);

    // Se necessário, adicione métodos adicionais conforme a lógica do seu repositório

}
