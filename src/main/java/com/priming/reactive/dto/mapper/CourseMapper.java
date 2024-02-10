package com.priming.reactive.dto.mapper;

import com.priming.reactive.dto.CourseDTO;
import com.priming.reactive.dto.CourseRequestDTO;
import com.priming.reactive.enums.Status;
import com.priming.reactive.model.infra.CourseCollection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CourseMapper {

    public CourseCollection toEntity(CourseRequestDTO courseRequestDTO) {
        CourseCollection courseCollection = new CourseCollection();
        courseCollection.setName(courseRequestDTO.name());
        courseCollection.setCategory(courseRequestDTO.category());
        courseCollection.setLessons(new ArrayList<>(courseRequestDTO.lessons()));
        return courseCollection;
    }

    public CourseDTO toDTO(CourseCollection courseCollection) {
        return new CourseDTO(
                courseCollection.get_id(),
                courseCollection.getName(),
                courseCollection.getCategory(),
                courseCollection.getLessons()
        );
    }

    public Status convertStatusValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "ACTIVE" -> Status.ACTIVE;
            case "INACTIVE" -> Status.INACTIVE;
            default -> throw new IllegalArgumentException("Invalid Status value: " + value);
        };
    }

}
