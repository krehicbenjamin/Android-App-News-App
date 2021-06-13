package com.example.mobileproject;

import android.content.Context;
import android.content.Intent;
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
    public static final String ARTICLE_EXTRA_ID = "extra_id";
    private ListView listView;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.list_view_container);
//        List<Articles> articles  = GolazoDatabase.getInstance(getActivity()).articleDao().getAll();
//        ArticleListAdapter adapter = new ArticleListAdapter(getActivity(), articles);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener((new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                long articleId = parent.getItemIdAtPosition(position);
//                Intent intent = new Intent (getActivity(), ArticleViewActivity.class);
//                intent.putExtra(ARTICLE_EXTRA_ID,articleId);
//                startActivity(intent);
//            }
//        }));
        setUpListAdapter();
    }

    public void setUpListAdapter () {
        List<Articles> todos = GolazoDatabase.getInstance(context).articleDao().getAll();
        ArticleListAdapter adapter = new ArticleListAdapter(context, todos);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {

            long postId = parent.getItemIdAtPosition(position);
            Intent intent = new Intent(getActivity(), ArticleViewActivity.class);
            intent.putExtra(ARTICLE_EXTRA_ID, postId);
            startActivity(intent);
        });
    }
}
