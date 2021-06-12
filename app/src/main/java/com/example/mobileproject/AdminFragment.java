package com.example.mobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AdminFragment extends Fragment {

    private EditText title, body;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin, container, false);
        title = view.findViewById(R.id.title_add);
        body = view.findViewById(R.id.body_add);
        return view;
    }

    public void onAdd(View view){
        Articles article = new Articles(title.getText().toString(),body.getText().toString());
        GolazoDatabase.getInstance(getActivity()).articleDao().add(article);
        Toast.makeText(getActivity(), "Succesfully added a new article", Toast.LENGTH_LONG).show();
    }
}
