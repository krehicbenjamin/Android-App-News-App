package com.example.mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import java.util.List;

public class ArticleListAdapter extends BaseAdapter {
    private Context context;
    private List<Articles> articlesList;

    public ArticleListAdapter(Context context, List<Articles> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @Override
    public int getCount() {
        return articlesList.size();
    }

    @Override
    public Object getItem(int position) {
        return articlesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return articlesList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.article_item, parent,false);
        Articles articles = articlesList.get(position);
        TextView articleTitile = convertView.findViewById(R.id.article_title);
        articleTitile.setText(articles.getTitle());
        TextView articleBody = convertView.findViewById(R.id.article_body);
        articleBody.setText(articles.getBody());
        return convertView;
    }
}
