package com.priming.reactive.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "CursoCollection")
public class CursoCollection {
    @Id
    private String id;

}

