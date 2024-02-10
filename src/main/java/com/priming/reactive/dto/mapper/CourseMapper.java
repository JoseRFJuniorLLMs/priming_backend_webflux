package com.priming.reactive.dto.mapper;

import com.priming.reactive.dto.CourseDTO;
import com.priming.reactive.dto.CourseRequestDTO;
import com.priming.reactive.dto.LessonDTO;
import com.priming.reactive.model.infra.CourseCollection;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseCollection toEntity(CourseRequestDTO courseRequestDTO) {
        CourseCollection courseCollection = new CourseCollection();
        courseCollection.setName(courseRequestDTO.name());
        courseCollection.setCategory(courseRequestDTO.category());
        courseCollection.setLessons(courseRequestDTO.lessons().stream()
                .map(LessonDTO::name)
                .collect(Collectors.toList()));
        return courseCollection;
    }

    public CourseDTO toDTO(CourseCollection courseCollection) {
        return new CourseDTO(
                courseCollection.getId(),
                courseCollection.getName(),
                courseCollection.getCategory(),
                courseCollection.getLessons()
        );
    }

    public Course toModel(CourseCollection courseCollection) {
        Course course = new Course();
        course.setName(courseCollection.getName());
        course.setCategory(courseCollection.getCategory());
        // Set other properties as needed
        return course;
    }

    public CourseCollection toCollection(Course course) {
        CourseCollection courseCollection = new CourseCollection();
        courseCollection.setId(course.getId());
        courseCollection.setName(course.getName());
        courseCollection.setCategory(course.getCategory());
        // Set other properties as needed
        return courseCollection;
    }
}
