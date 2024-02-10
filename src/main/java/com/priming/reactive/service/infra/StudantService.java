package com.priming.reactive.service.infra;

import com.priming.reactive.model.infra.StudantCollection;
import com.priming.reactive.repository.infra.StudantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StudantService {

    @Autowired
    private StudantRepository studantRepository;

    public Flux<StudantCollection> findAll() {
        return studantRepository.findAll();
    }

    public Flux<StudantCollection> findByCourse(String course) {
        return studantRepository.findByCourse(course);
    }

}
