package com.example.oaeeventcms;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String series;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String imageSrc;
    private String imageAlt;
    private String uniqueURL;
    @Column(nullable = false)
    private Boolean featuredEvent;
    private Intro intro;
    @ElementCollection(targetClass = Schedule.class)
    @OrderColumn(name="order_id")
    private List<Schedule> schedule;
    private Theme theme;

    public Event(String name, String series, String time, String date, String location, String imageSrc, String imageAlt, String uniqueURL, Boolean featuredEvent, Intro intro, List<Schedule> schedule, Theme theme) {
        this.name = name;
        this.series = series;
        this.time = time;
        this.date = date;
        this.location = location;
        this.imageSrc = imageSrc;
        this.imageAlt = imageAlt;
        this.uniqueURL = uniqueURL;
        this.featuredEvent = featuredEvent;
        this.intro = intro;
        this.schedule = schedule;
        this.theme = theme;
    }

    public Event() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeries() {
        return series;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public String getUniqueURL() {
        return uniqueURL;
    }

    public Boolean getFeaturedEvent() {
        return featuredEvent;
    }

    public Intro getIntro() {
        return intro;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setUniqueAlt(String uniqueURL) {
        this.uniqueURL = uniqueURL;
    }

    public void setFeaturedEvent(Boolean featuredEvent) {
        this.featuredEvent = featuredEvent;
    }

    public void setIntro(Intro intro) {
        this.intro = intro;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
