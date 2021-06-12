package com.example.mobileproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {

    @Insert
    void makeNewArticle (Articles article);

    @Query("SELECT * FROM articles")
    List<Articles> getAllArticles ();

}
