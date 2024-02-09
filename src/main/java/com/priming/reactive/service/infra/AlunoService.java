package com.priming.reactive.service.infra;

import com.priming.reactive.model.infra.AlunoCollection;
import com.priming.reactive.repository.infra.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Flux<AlunoCollection> findAll() {
        return alunoRepository.findAll();
    }

    public Flux<AlunoCollection> findByCurso(String curso) {
        return alunoRepository.findByCurso(curso);
    }

}
