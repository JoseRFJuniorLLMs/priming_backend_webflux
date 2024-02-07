package com.priming.reactive.service.infra;

import com.priming.reactive.model.infra.ClassroomCollection;
import com.priming.reactive.repository.infra.ClassroomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ClassroomService {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomService.class);

    @Autowired
    private ClassroomRepository classroomRepository;

    public Flux<ClassroomCollection> findClassroomsByAlunoId(String alunoId) {
        logger.info("Searching classrooms by alunoId: {}", alunoId);
        return classroomRepository.findByAlunoId(alunoId);
    }
}
