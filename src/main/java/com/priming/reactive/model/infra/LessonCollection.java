package com.priming.reactive.model.infra;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class LessonCollection {
    @Id
    private String _id;
    private String name;
    private String youtubeUrl;
    private String course;
    private String time;

    public LessonCollection(String _id, String name, String youtubeUrl, String course, String time) {
        this._id = _id;
        this.name = name;
        this.youtubeUrl = youtubeUrl;
        this.course = course;
        this.time = time;
    }

    public LessonCollection() {
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

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonCollection that = (LessonCollection) o;
        return Objects.equals(_id, that._id) && Objects.equals(name, that.name) && Objects.equals(youtubeUrl, that.youtubeUrl) && Objects.equals(course, that.course) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, youtubeUrl, course, time);
    }
}
