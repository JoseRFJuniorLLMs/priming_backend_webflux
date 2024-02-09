package com.priming.reactive.controller.infra;

import com.priming.reactive.model.infra.CourseCollection;
import com.priming.reactive.service.infra.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CourseCollection> getAllCourses(@RequestParam(required = false) String category) {
        LOGGER.info("Request received to get all courses");
        if (category == null) {
            LOGGER.info("Fetching all courses");
            return courseService.findAll();
        } else {
            LOGGER.info("Fetching courses by category: {}", category);
            return courseService.findCoursesByCategory(category);
        }
    }

    @GetMapping("/course/{id}")
    public Mono<CourseCollection> getCourseById(@PathVariable String id) {
        LOGGER.info("Request received to get course by ID: {}", id);
        return courseService.findById(id);
    }

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CourseCollection> createCourse(@RequestBody CourseCollection course) {
        LOGGER.info("Request received to create course: {}", course);
        return courseService.save(course);
    }

    @PutMapping("/course/{id}")
    public Mono<CourseCollection> updateCourse(@PathVariable String id, @RequestBody CourseCollection course) {
        LOGGER.info("Request received to update course with ID: {}", id);
        return courseService.update(id, course);
    }

    @DeleteMapping("/course/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCourse(@PathVariable String id) {
        LOGGER.info("Request received to delete course with ID: {}", id);
        return courseService.deleteById(id);
    }

    @GetMapping("/course/category/{category}")
    public Flux<CourseCollection> getCoursesByCategory(@PathVariable String category) {
        LOGGER.info("Request received to get courses by category: {}", category);
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/course/name/{name}")
    public Flux<CourseCollection> getCoursesByName(@PathVariable String name) {
        LOGGER.info("Request received to get courses by name: {}", name);
        return courseService.findCoursesByName(name);
    }
}
