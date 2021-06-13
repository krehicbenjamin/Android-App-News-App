package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ArticleViewActivity extends AppCompatActivity {
    private TextView title, body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_view);
        Bundle extras = getIntent().getExtras();

        title = findViewById(R.id.article_title);
        body = findViewById(R.id.article_body);

        long id = extras.getLong(HomeFragment.ARTICLE_EXTRA_ID);
        Articles articles = GolazoDatabase.getInstance(this).articleDao().getArticleById(id);
        title.setText(articles.getTitle());
        body.setText(articles.getBody());
    }
}