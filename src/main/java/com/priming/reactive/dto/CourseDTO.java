package com.priming.reactive.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
        @JsonProperty("_id") String id,
        @NotBlank String name,
        @NotBlank String objective,
        @NotNull List<String> content
) {
}
