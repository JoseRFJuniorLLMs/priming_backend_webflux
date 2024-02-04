package com.priming.reactive.controller;

import com.priming.reactive.model.AlunoCollection;
import com.priming.reactive.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("/aluno")
    @ResponseStatus(HttpStatus.OK)
    public Flux<AlunoCollection> getAllAlunos(@RequestParam(required = false) String curso) {
        if (curso == null)
            return alunoService.findAll();
        else
            return alunoService.findByCurso(curso);
    }
}
