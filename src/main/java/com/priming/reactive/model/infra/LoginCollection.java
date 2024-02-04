package com.priming.reactive.model.infra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "LoginCollection")
public class LoginCollection {
    @Id
    private String id;

}

