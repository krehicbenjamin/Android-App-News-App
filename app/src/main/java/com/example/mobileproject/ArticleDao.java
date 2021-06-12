package com.example.mobileproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {

    @Insert
    void add(Articles article);

    @Query("SELECT * FROM articles")
    List<Articles> getAll();

    @Query("SELECT * FROM articles WHERE id = :id LIMIT 1")
    Articles getArticleById(long id);
}
