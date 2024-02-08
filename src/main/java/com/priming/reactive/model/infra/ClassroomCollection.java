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
    private List<String> phrases;

    public ClassroomCollection(String id, String alunoId, String curso, String modulo, List<String> prime, List<String> target, List<String> phrases) {
        this.id = id;
        this.alunoId = alunoId;
        this.curso = curso;
        this.modulo = modulo;
        this.prime = prime;
        this.target = target;
        this.phrases = phrases;
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

    public List<String> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<String> phrases) {
        this.phrases = phrases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomCollection that = (ClassroomCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(alunoId, that.alunoId) && Objects.equals(curso, that.curso) && Objects.equals(modulo, that.modulo) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(phrases, that.phrases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alunoId, curso, modulo, prime, target, phrases);
    }
}
