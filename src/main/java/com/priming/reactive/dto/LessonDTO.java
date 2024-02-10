package com.priming.reactive.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Used as response and request object that represents a Lesson.
 */
public record LessonDTO(
        String _id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String name,
        @NotBlank @NotNull @Length(min = 10, max = 100) String youtubeUrl) {
}
