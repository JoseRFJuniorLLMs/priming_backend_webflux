package com.priming.reactive.controller.infra;

import com.priming.reactive.model.core.PrimeTargetCollection;
import com.priming.reactive.model.infra.AlunoCollection;
import com.priming.reactive.model.core.PrimeTargetPhraseCollection;
import com.priming.reactive.model.core.PrimeTargetTextCollection;
import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;


import com.priming.reactive.service.core.PrimeTargetService;
import com.priming.reactive.service.infra.AlunoService;
import com.priming.reactive.service.core.PrimeTargetPhraseService;
import com.priming.reactive.service.core.PrimeTargetTextService;
import com.priming.reactive.service.core.PrimeTargetYoutubeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    private PrimeTargetService primeTargetService;
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PrimeTargetPhraseService primeTargetPhraseService;

    @Autowired
    private PrimeTargetTextService primeTargetTextService;

    @Autowired
    private PrimeTargetYoutubeService primeTargetYoutubeService;

    @GetMapping("/aluno")
    @ResponseStatus(HttpStatus.OK)
    public Flux<AlunoCollection> getAllAlunos(@RequestParam(required = false) String curso) {
        if (curso == null) {
            return alunoService.findAll();
        } else {
            return alunoService.findByCurso(curso);
        }
    }

    @GetMapping("/aluno/info/{target}")
    public Mono<AlunoTargetInfo> getAlunoTargetInfo(@PathVariable String target) {
        Mono<PrimeTargetCollection> primingInfo = primeTargetService.findSingleTargetByPrime(target);
        Mono<PrimeTargetPhraseCollection> fraseInfo = primeTargetPhraseService.findTargetAndPhraseByPrime(target);
        Mono<PrimeTargetTextCollection> textInfo = primeTargetTextService.findTargetAndTextByPrime(target);
        Mono<PrimeTargetYoutubeCollection> youtubeInfo = primeTargetYoutubeService.findTargetAndUrlByPrime(target);

        return Mono.zip(fraseInfo, textInfo, primingInfo, youtubeInfo)
                .map(tuple -> new AlunoTargetInfo(tuple.getT1(), tuple.getT2(), tuple.getT3(), tuple.getT4()));
    }
}
