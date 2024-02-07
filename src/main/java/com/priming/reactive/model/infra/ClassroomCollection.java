package com.priming.reactive.model.infra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Objects;

public class ClassroomCollection {

    @Id
    private String id;
    private String alunoId;
    private String curso;
    private String modulo;
    private List<String> prime;
    private List<String> target;
    private List<String> frase;

    @Field("audioUrls")
    private List<String> audioUrls;

    @Field("ImageUrls")
    private List<String> ImageUrls;

    @Field("videoUrls")
    private List<String> videoUrls;
    private String text;

    public ClassroomCollection(String id, String alunoId, String curso, String modulo, List<String> prime, List<String> target, List<String> frase, List<String> audioUrls, List<String> ImageUrls, List<String> videoUrls, String text) {
        this.id = id;
        this.alunoId = alunoId;
        this.curso = curso;
        this.modulo = modulo;
        this.prime = prime;
        this.target = target;
        this.frase = frase;
        this.audioUrls = audioUrls;
        this.ImageUrls = ImageUrls;
        this.videoUrls = videoUrls;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public List<String> getPrime() {
        return prime;
    }

    public void setPrime(List<String> prime) {
        this.prime = prime;
    }

    public List<String> getTarget() {
        return target;
    }

    public void setTarget(List<String> target) {
        this.target = target;
    }

    public List<String> getFrase() {
        return frase;
    }

    public void setFrase(List<String> frase) {
        this.frase = frase;
    }

    public List<String> getUrlAudio() {
        return audioUrls;
    }

    public void setUrlAudio(List<String> audioUrls) {
        this.audioUrls = audioUrls;
    }

    public List<String> getUrlImagem() {
        return ImageUrls;
    }

    public void setUrlImagem(List<String> ImageUrls) {
        this.ImageUrls = ImageUrls;
    }

    public List<String> getUrlVideo() {
        return videoUrls;
    }

    public void setUrlVideo(List<String> videoUrls) {
        this.videoUrls = videoUrls;
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
        ClassroomCollection that = (ClassroomCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(alunoId, that.alunoId) && Objects.equals(curso, that.curso) && Objects.equals(modulo, that.modulo) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(frase, that.frase) && Objects.equals(audioUrls, that.audioUrls) && Objects.equals(ImageUrls, that.ImageUrls) && Objects.equals(videoUrls, that.videoUrls) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alunoId, curso, modulo, prime, target, frase, audioUrls, ImageUrls, videoUrls, text);
    }
}
