package com.priming.reactive.model.core;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "primeTargetFraseCollection")
public class PrimeTargetFraseCollection {
    @Id
    private String id;

    private String prime;

    private String target;

    private List<String> frase;

    private String url;

}