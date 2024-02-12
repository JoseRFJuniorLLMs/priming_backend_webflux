package com.priming.reactive.model.infra;

import com.priming.reactive.enums.converters.StatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotNull;

import com.priming.reactive.enums.Status;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "StudentCollection")
public class StudentCollection {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String tax_identification_number;
    @NotNull
    private String personal_identification_number;
    @NotNull
    private String login;
    @NotNull
    private String password;

    @Builder.Default()
    private List<String> roles = new ArrayList<>();

    @NotNull
    @Column(length = 8, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;
    private List<String> course;
    private List<String> prime;


}

