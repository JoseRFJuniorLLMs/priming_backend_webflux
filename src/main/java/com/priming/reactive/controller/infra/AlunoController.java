package com.priming.reactive.controller.infra;

import com.priming.reactive.model.infra.AlunoCollection;
import com.priming.reactive.model.core.PrimeTargetFraseCollection;
import com.priming.reactive.model.core.PrimeTargetTextCollection;
import com.priming.reactive.service.infra.AlunoService;
import com.priming.reactive.service.core.PrimeTargetFraseService;
import com.priming.reactive.service.core.PrimeTargetTextService;
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
    private AlunoService alunoService;

    @Autowired
    private PrimeTargetFraseService primeTargetFraseService;

    @Autowired
    private PrimeTargetTextService primeTargetTextService;

    @GetMapping("/aluno")
    @ResponseStatus(HttpStatus.OK)
    public Flux<AlunoCollection> getAllAlunos(@RequestParam(required = false) String curso) {
        if (curso == null) {
            return alunoService.findAll();
        } else {
            return alunoService.findByCurso(curso);
        }
    }

    @GetMapping("/aluno/target-info")
    public Mono<AlunoTargetInfo> getAlunoTargetInfo(@RequestParam String target) {
        Mono<PrimeTargetFraseCollection> fraseInfo = primeTargetFraseService.findTargetAndTextByPrime(target);
        Mono<PrimeTargetTextCollection> textInfo = primeTargetTextService.findTargetAndTextByPrime(target);

        return Mono.zip(fraseInfo, textInfo)
                .map(tuple -> new AlunoTargetInfo(tuple.getT1(), tuple.getT2()));
    }

    public static class AlunoTargetInfo {
        private final PrimeTargetFraseCollection fraseInfo;
        private final PrimeTargetTextCollection textInfo;

        public AlunoTargetInfo(PrimeTargetFraseCollection fraseInfo, PrimeTargetTextCollection textInfo) {
            this.fraseInfo = fraseInfo;
            this.textInfo = textInfo;
        }

        public PrimeTargetFraseCollection getFraseInfo() {
            return fraseInfo;
        }

        public PrimeTargetTextCollection getTextInfo() {
            return textInfo;
        }
    }
}
