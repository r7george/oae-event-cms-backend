package com.example.oaeeventcms;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Schedule {

    private String name;
    private String title;
    private String author;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String alternateDescription;

    public Schedule(String name, String title, String author, String description, String alternateDescription) {
        this.name = name;
        this.title = title;
        this.author = author;
        this.description = description;
        this.alternateDescription = alternateDescription;
    }

    public Schedule() {

    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getAlternateDescription() {
        return alternateDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlternateDescription(String alternateDescription) {
        this.alternateDescription = alternateDescription;
    }
}
