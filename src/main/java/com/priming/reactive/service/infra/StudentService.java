package com.priming.reactive.service.infra;

import com.priming.reactive.model.infra.StudentCollection;
import com.priming.reactive.repository.infra.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Flux<StudentCollection> findAll() {
        return studentRepository.findAll();
    }

    public Flux<StudentCollection> findByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

}
