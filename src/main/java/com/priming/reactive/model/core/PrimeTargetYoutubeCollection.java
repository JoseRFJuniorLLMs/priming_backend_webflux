package com.priming.reactive.model.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "primeTargetYoutubeCollection")
public class PrimeTargetYoutubeCollection {

    @Id
    private String id;

    private String prime;

    private String target;

    private List<String> url;

    public PrimeTargetYoutubeCollection(String id, String prime, String target, List<String> url) {
        this.id = id;
        this.prime = prime;
        this.target = target;
        this.url = url;
    }

    public PrimeTargetYoutubeCollection() {
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

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeTargetYoutubeCollection that = (PrimeTargetYoutubeCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target, url);
    }
}