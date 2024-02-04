// PrimeTargetTextService.java
package com.priming.reactive.service.core;

import com.priming.reactive.model.core.PrimeTargetTextCollection;
import com.priming.reactive.repository.core.PrimeTargetTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PrimeTargetTextService {

    @Autowired
    private PrimeTargetTextRepository primeTargetTextRepository;

    public Mono<PrimeTargetTextCollection> findTargetAndTextByPrime(String prime) {
        return primeTargetTextRepository.findTargetAndTextByPrime(prime)
                .collectList()
                .flatMap(results -> {
                    if (results.isEmpty()) {
                        return Mono.error(new RuntimeException("Nenhum resultado encontrado para a palavra-chave: " + prime));
                    } else if (results.size() > 1) {
                        // Tratar o caso de múltiplos resultados, aqui você pode escolher a lógica apropriada
                        // Neste exemplo, estou retornando o primeiro resultado, mas você pode escolher outra abordagem
                        return Mono.just(results.get(0));
                    } else {
                        return Mono.just(results.get(0));
                    }
                });
    }
}
