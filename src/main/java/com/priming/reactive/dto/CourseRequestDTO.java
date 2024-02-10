package com.priming.reactive.dto;

import com.priming.reactive.enums.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "CourseCollection")
public record CourseRequestDTO(
        @NotBlank @NotNull @Length(min = 5, max = 200) String name,
        @NotBlank @NotNull String category,
        @NotEmpty @Valid List<String> content,
        @NotEmpty @Valid List<String> lessons,
        String level,
        String price,
        @NotNull Status status) {
}
