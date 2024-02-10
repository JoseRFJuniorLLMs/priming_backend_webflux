package com.priming.reactive.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseDTO(
        @JsonProperty("_id") String id,
        String name,
        String objective,
        List<String> content,
        List<String> lessons,
        String category,
        String level,
        String price) {
}
