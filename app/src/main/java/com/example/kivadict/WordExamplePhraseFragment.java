package com.example.kivadict;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WordExamplePhraseFragment extends Fragment {

    private TextView wordText;
    private WordExampleViewModel wordExampleViewModel;
    private RecyclerView recyclerView;
    private WordExampleListAdapter adapter;


    public static final String ENTRY_KEY = "entry";

    public WordExamplePhraseFragment() {

        super(R.layout.examples_layout);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View parentView = inflater.inflate(R.layout.examples_layout, container, false);
        recyclerView = parentView.findViewById(R.id.example_list);
        adapter = new WordExampleListAdapter(new WordExampleListAdapter.SentenceDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        wordExampleViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication()))
                .get(WordExampleViewModel.class);
        wordExampleViewModel.exampleSentencesList.observe(getViewLifecycleOwner(), adapter::submitList);
        WordWithGlosses entry = (WordWithGlosses) getArguments().getSerializable("entry");
        wordExampleViewModel.word.setValue(entry.getWord().getWord());
    }

}
