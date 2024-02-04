package com.priming.reactive.model.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "primeCollection")
public class PrimeTargetCollection {
    @Id
    private String id;

    private String prime;

    private String target;

    public PrimeTargetCollection(String id, String prime, String target) {
        this.id = id;
        this.prime = prime;
        this.target = target;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeTargetCollection that = (PrimeTargetCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target);
    }
}
