package com.priming.reactive.model.core;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "primeTargetFraseCollection")
public class PrimeTargetFraseCollection {
    @Id
    private String id;

    private String prime;

    private String target;

    private List<String> frase;

    private List<String> url;

    private List<String> imagem;

    public PrimeTargetFraseCollection(String id, String prime, String target, List<String> frase, List<String> url, List<String> imagem) {
        this.id = id;
        this.prime = prime;
        this.target = target;
        this.frase = frase;
        this.url = url;
        this.imagem = imagem;
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

    public List<String> getFrase() {
        return frase;
    }

    public void setFrase(List<String> frase) {
        this.frase = frase;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getImagem() {
        return imagem;
    }

    public void setImagem(List<String> imagem) {
        this.imagem = imagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeTargetFraseCollection that = (PrimeTargetFraseCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(frase, that.frase) && Objects.equals(url, that.url) && Objects.equals(imagem, that.imagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target, frase, url, imagem);
    }
}