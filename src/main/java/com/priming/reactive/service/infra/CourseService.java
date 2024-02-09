package com.priming.reactive.service.infra;

import com.priming.reactive.model.infra.AlunoCollection;
import com.priming.reactive.model.infra.CourseCollection;
import com.priming.reactive.repository.infra.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService {

   @Autowired
    private CourseRepository courseRepository;

    public Flux<CourseCollection> findAll() {
        return courseRepository.findAll();
    }

    public Flux<CourseCollection> findByCurso(String curso) {
        return courseRepository.findByName(curso);
    }
    public Mono<CourseCollection> findById(String id) {
        return courseRepository.findById(id);
    }

    public Mono<CourseCollection> save(CourseCollection course) {
        return courseRepository.save(course);
    }

    public Mono<CourseCollection> update(String id, CourseCollection course) {
        return courseRepository.findById(id)
                .flatMap(existingCourse -> {
                    existingCourse.setName(course.getName());
                    existingCourse.setObjective(course.getObjective());
                    existingCourse.setContent(course.getContent());
                    existingCourse.setLessons(course.getLessons());
                    existingCourse.setCategory(course.getCategory());
                    return courseRepository.save(existingCourse);
                });
    }

    public Mono<Void> deleteById(String id) {
        return courseRepository.deleteById(id);
    }

    public Flux<CourseCollection> findCoursesByCategory(String category) {
        return courseRepository.findByCategory(category);
    }

    public Flux<CourseCollection> findCoursesByName(String name) {
        return courseRepository.findByName(name);
    }
}
