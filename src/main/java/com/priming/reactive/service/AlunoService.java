package com.priming.reactive.service;

import com.priming.reactive.model.AlunoCollection;
import com.priming.reactive.repository.AlunoRepository;
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

    // Se necessário, adicione métodos adicionais conforme a lógica do seu serviço

}
