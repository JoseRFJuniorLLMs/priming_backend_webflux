package com.priming.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "AlunoCollection")
public class AlunoCollection {
    @Id
    private String id;

    private String nome;

    private String cpf;

    private String curso;

    private List<String> prime;

    public AlunoCollection(String id, String nome, String cpf, String curso, List<String> prime) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.prime = prime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<String> getPrime() {
        return prime;
    }

    public void setPrime(List<String> prime) {
        this.prime = prime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoCollection that = (AlunoCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(curso, that.curso) && Objects.equals(prime, that.prime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, curso, prime);
    }
}

