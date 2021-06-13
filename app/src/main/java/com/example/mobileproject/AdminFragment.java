package com.example.mobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AdminFragment extends Fragment {

    private EditText title, body;
    private Button add_article;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin, container, false);
        title = view.findViewById(R.id.title_add);
        body = view.findViewById(R.id.body_add);
        add_article = view.findViewById(R.id.submit_article);
        add_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Articles article = new Articles(title.getText().toString(), body.getText().toString());

                GolazoDatabase golazoDatabase = GolazoDatabase.getInstance(getActivity().getApplicationContext());

                golazoDatabase.articleDao().add(article);

                Toast.makeText(getActivity(), "Article created succesfully!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}
