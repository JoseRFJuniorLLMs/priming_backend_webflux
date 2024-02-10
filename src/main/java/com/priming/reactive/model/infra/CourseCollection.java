package com.priming.reactive.model.infra;

import com.priming.reactive.enums.Status;
import com.priming.reactive.enums.converters.StatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "CourseCollection")
public class CourseCollection {
    @Id
    private String _id;
    private String name;
    private String objective;
    private List<String> content;
    private List<String> lessons;
    private String category;
    private String level;
    private String price;
    @Column(length = 8, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    public CourseCollection(String _id, String name, String objective, List<String> content, List<String> lessons, String category, String level, String price, Status status) {
        this._id = _id;
        this.name = name;
        this.objective = objective;
        this.content = content;
        this.lessons = lessons;
        this.category = category;
        this.level = level;
        this.price = price;
        this.status = status;
    }

    public CourseCollection() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<String> getLessons() {
        return lessons;
    }

    public void setLessons(List<String> lessons) {
        if (lessons == null) {
            throw new IllegalArgumentException("Lessons cannot be null.");
        }
        this.lessons = lessons;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCollection that = (CourseCollection) o;
        return Objects.equals(_id, that._id) && Objects.equals(name, that.name) && Objects.equals(objective, that.objective) && Objects.equals(content, that.content) && Objects.equals(lessons, that.lessons) && Objects.equals(category, that.category) && Objects.equals(level, that.level) && Objects.equals(price, that.price) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, objective, content, lessons, category, level, price, status);
    }
}
