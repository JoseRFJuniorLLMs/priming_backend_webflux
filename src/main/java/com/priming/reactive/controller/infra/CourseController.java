package com.priming.reactive.controller.infra;

import com.priming.reactive.model.infra.CourseCollection;
import com.priming.reactive.service.infra.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CourseCollection> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/course/{id}")
    public Mono<CourseCollection> getCourseById(@PathVariable String id) {
        return courseService.findById(id);
    }

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CourseCollection> createCourse(@RequestBody CourseCollection course) {
        return courseService.save(course);
    }

    @PutMapping("/course/{id}")
    public Mono<CourseCollection> updateCourse(@PathVariable String id, @RequestBody CourseCollection course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/course/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCourse(@PathVariable String id) {
        return courseService.deleteById(id);
    }

    @GetMapping("/course/category/{category}")
    public Flux<CourseCollection> getCoursesByCategory(@PathVariable String category) {
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/course/name/{name}")
    public Flux<CourseCollection> getCoursesByName(@PathVariable String name) {
        return courseService.findCoursesByName(name);
    }
}
