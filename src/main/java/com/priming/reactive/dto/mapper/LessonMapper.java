package com.priming.reactive.dto.mapper;

import com.priming.reactive.dto.LessonDTO;
import com.priming.reactive.model.infra.LessonCollection;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    public LessonDTO toDTO(LessonCollection lessonCollection) {
        return new LessonDTO(
                lessonCollection.get_id(),
                lessonCollection.getName(),
                lessonCollection.getYoutubeUrl()
        );
    }

    public LessonCollection toEntity(LessonDTO lessonDTO) {
        LessonCollection lessonCollection = new LessonCollection();
        lessonCollection.setName(lessonDTO.name());
        lessonCollection.setYoutubeUrl(lessonDTO.youtubeUrl());
        return lessonCollection;
    }
}
