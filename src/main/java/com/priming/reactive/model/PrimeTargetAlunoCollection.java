package com.priming.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "primeTargetAlunoCollection")
public class PrimeTargetAlunoCollection {
    @Id
    private String id;

    private String prime;

    private String target;

    private String text;

    public PrimeTargetAlunoCollection(String id, String prime, String target, String text) {
        this.id = id;
        this.prime = prime;
        this.target = target;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeTargetAlunoCollection that = (PrimeTargetAlunoCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target, text);
    }
}


