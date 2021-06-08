package com.example.mobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Articles> articles  = new ArrayList<>();
        ArticleListAdapter adapter = new ArticleListAdapter(getActivity(), articles);
        articles.add(new Articles("title 1", "body"));
        articles.add(new Articles("title 1", "body"));
        articles.add(new Articles("title 1", "body"));
        articles.add(new Articles("title 1", "body"));

        listView.setAdapter(adapter);
    }


}
