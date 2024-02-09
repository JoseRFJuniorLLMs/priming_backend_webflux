package com.priming.reactive.model.infra;

import com.priming.reactive.enums.converters.StatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotNull;

import com.priming.reactive.enums.Status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "AlunoCollection")
public class AlunoCollection {
    @Id
    private String id;
    @NotNull
    private String nome;
    @NotNull
    private String tax_identification_number;
    @NotNull
    private String personal_identification_number;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    @Column(length = 8, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;
    private List<String> curso;
    private List<String> prime;

    public AlunoCollection(String id, String nome, String tax_identification_number, String personal_identification_number, String login, String password, Status status, List<String> curso, List<String> prime) {
        this.id = id;
        this.nome = nome;
        this.tax_identification_number = tax_identification_number;
        this.personal_identification_number = personal_identification_number;
        this.login = login;
        this.password = password;
        this.status = status;
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

    public String getTax_identification_number() {
        return tax_identification_number;
    }

    public void setTax_identification_number(String tax_identification_number) {
        this.tax_identification_number = tax_identification_number;
    }

    public String getPersonal_identification_number() {
        return personal_identification_number;
    }

    public void setPersonal_identification_number(String personal_identification_number) {
        this.personal_identification_number = personal_identification_number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getCurso() {
        return curso;
    }

    public void setCurso(List<String> curso) {
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
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(tax_identification_number, that.tax_identification_number) && Objects.equals(personal_identification_number, that.personal_identification_number) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && status == that.status && Objects.equals(curso, that.curso) && Objects.equals(prime, that.prime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tax_identification_number, personal_identification_number, login, password, status, curso, prime);
    }
}

