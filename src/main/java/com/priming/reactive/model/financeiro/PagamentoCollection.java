package com.priming.reactive.model.financeiro;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PagamentoCollection")
public class PagamentoCollection {
    @Id
    private String id;
}
