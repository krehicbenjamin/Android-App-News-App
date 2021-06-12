package com.example.mobileproject;

import android.media.Image;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class Articles {

    @PrimaryKey
    private long id;

    private String title;
    private String body;


    public Articles(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
