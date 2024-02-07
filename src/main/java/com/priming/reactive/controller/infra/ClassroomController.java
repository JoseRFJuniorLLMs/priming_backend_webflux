package com.priming.reactive.controller.infra;

import com.priming.reactive.service.infra.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ClassroomController {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/classroom/alunoId/{alunoId}")
    public Mono<ResponseEntity<?>> getClassroomByAlunoId(@PathVariable String alunoId) {
        logger.info("Request received to get classroom by alunoId: {}", alunoId);

        return classroomService.findClassroomsByAlunoId(alunoId)
                .collectList()
                .flatMap(classrooms -> {
                    if (!classrooms.isEmpty()) {
                        logger.info("Returning classrooms: {}", classrooms);
                        return Mono.just(ResponseEntity.ok(classrooms));
                    } else {
                        logger.warn("No classrooms found for alunoId: {}", alunoId);
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("No classrooms found for alunoId: " + alunoId));
                    }
                })
                .doOnError(throwable -> {
                    logger.error("Error while processing request for alunoId: {}", alunoId, throwable);
                })
                .onErrorResume(throwable -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)));
    }
}
