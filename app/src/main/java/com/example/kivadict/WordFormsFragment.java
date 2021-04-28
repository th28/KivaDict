package com.example.kivadict;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kivadict.R;
import com.example.kivadict.WordWithGlosses;

public class WordFormsFragment extends Fragment {

    private TextView wordText;
    public static final String ENTRY_KEY = "entry";
    private RecyclerView recyclerView;

    public WordFormsFragment(){

        super(R.layout.forms_layout);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.forms_layout, container, false);
        recyclerView = parentView.findViewById(R.id.form_list);
        
        return parentView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        WordWithGlosses entry = (WordWithGlosses) getArguments().getSerializable("entry");


    }

}
