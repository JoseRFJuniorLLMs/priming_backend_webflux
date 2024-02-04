package com.priming.reactive.model.infra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professorCollection")
public class ProfessorCollection {
    @Id
    private String id;

    private String nome;

    private String cpf;

    private String curso;
}
