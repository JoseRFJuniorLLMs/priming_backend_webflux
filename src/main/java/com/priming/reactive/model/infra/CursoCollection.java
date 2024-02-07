package com.priming.reactive.model.infra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "CursoCollection")
public class CursoCollection {
    @Id
    private String _id;

    private String name;

    private String objective;

    private List<LessonCollection> content;

    private List<LessonCollection> lessonCollections;

    private String category;

    public CursoCollection() {
    }

    public CursoCollection(String name, String objective, List<LessonCollection> content, List<LessonCollection> lessonCollections, String category) {
        this.name = name;
        this.objective = objective;
        this.content = content;
        this.lessonCollections = lessonCollections;
        this.category = category;
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

    public List<LessonCollection> getContent() {
        return content;
    }

    public void setContent(List<LessonCollection> content) {
        this.content = content;
    }

    public List<LessonCollection> getLessons() {
        return lessonCollections;
    }

    public void setLessons(List<LessonCollection> lessonCollections) {
        this.lessonCollections = lessonCollections;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoCollection that = (CursoCollection) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(objective, that.objective) &&
                Objects.equals(content, that.content) &&
                Objects.equals(lessonCollections, that.lessonCollections) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, objective, content, lessonCollections, category);
    }

    @Override
    public String toString() {
        return "CursoCollection{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", objective='" + objective + '\'' +
                ", content=" + content +
                ", lessons=" + lessonCollections +
                ", category='" + category + '\'' +
                '}';
    }
}
