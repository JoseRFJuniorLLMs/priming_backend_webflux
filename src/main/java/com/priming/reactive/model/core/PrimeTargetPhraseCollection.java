package com.priming.reactive.model.core;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "primeTargetPhraseCollection")
public class PrimeTargetPhraseCollection {
    @Id
    private String id;

    private String prime;

    private String target;

    private List<String> phrase;

    private List<String> url;

    private List<String> imagem;

    public PrimeTargetPhraseCollection(String id, String prime, String target, List<String> phrase, List<String> url, List<String> imagem) {
        this.id = id;
        this.prime = prime;
        this.target = target;
        this.phrase = phrase;
        this.url = url;
        this.imagem = imagem;
    }

    public PrimeTargetPhraseCollection() {
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

    public List<String> getPhrase() {
        return phrase;
    }

    public void setPhrase(List<String> phrase) {
        this.phrase = phrase;
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
        PrimeTargetPhraseCollection that = (PrimeTargetPhraseCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(phrase, that.phrase) && Objects.equals(url, that.url) && Objects.equals(imagem, that.imagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target, phrase, url, imagem);
    }
}