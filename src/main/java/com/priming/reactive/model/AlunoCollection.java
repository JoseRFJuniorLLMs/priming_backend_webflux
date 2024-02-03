package com.priming.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "AlunoCollection")
public class AlunoCollection {
    @Id
    private String id;

}

