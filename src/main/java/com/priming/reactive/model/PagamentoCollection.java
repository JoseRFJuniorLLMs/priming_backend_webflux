package com.priming.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagamentoCollection")
public class PagamentoCollection {

    @Id
    private String id;
}
