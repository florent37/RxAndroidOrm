package com.github.florent37.rxandroidorm.sample.model;

import com.github.florent37.rxandroidorm.annotations.Id;
import com.github.florent37.rxandroidorm.annotations.Ignore;
import com.github.florent37.rxandroidorm.annotations.Model;

import java.util.Date;

@Model
public class Cat {

    public static final int VISIBLE = 0;

    @Id
    long id;

    String shortName;
    Date date;

    String notIgnored;
    @Ignore
    String ignoreThis;

    public Cat() {
    }

    public Cat(String shortName) {
        this.shortName = shortName;
    }

    public Cat(long id, String shortName) {
        this.id = id;
        this.shortName = shortName;
    }

    public Cat(String shortName, Date date) {
        this.shortName = shortName;
        this.date = date;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public Date getDate() {
        return date;
    }

    public long getId() {
        return id;
    }
}
