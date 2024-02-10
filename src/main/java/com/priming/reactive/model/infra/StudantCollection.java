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

@Document(collection = "StudantCollection")
public class StudantCollection {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String email;
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
    private List<String> course;
    private List<String> prime;

    public StudantCollection(String id, String name, String email, String tax_identification_number, String personal_identification_number, String login, String password, Status status, List<String> course, List<String> prime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tax_identification_number = tax_identification_number;
        this.personal_identification_number = personal_identification_number;
        this.login = login;
        this.password = password;
        this.status = status;
        this.course = course;
        this.prime = prime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
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
        StudantCollection that = (StudantCollection) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(tax_identification_number, that.tax_identification_number) && Objects.equals(personal_identification_number, that.personal_identification_number) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && status == that.status && Objects.equals(course, that.course) && Objects.equals(prime, that.prime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, tax_identification_number, personal_identification_number, login, password, status, course, prime);
    }
}

