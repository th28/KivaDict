package com.example.kivadict;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.w3c.dom.Text;

public class WordDetailFragment extends Fragment {

    private TextView wordText;
    private TextView posText;
    private TextView glossesText;


    public WordDetailFragment(){

        super(R.layout.word_detail_fragment);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.word_detail_fragment, container, false);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        wordText = view.findViewById(R.id.detail_word);
        posText = view.findViewById(R.id.detail_pos);
        glossesText = view.findViewById(R.id.detail_meaning_txt);
        WordWithGlosses entry = WordDetailFragmentArgs.fromBundle(getArguments()).getWordWithGlosses();
        wordText.setText(entry.getWord().getWord());
        posText.setText(entry.getWord().getPartOfSpeech());
        glossesText.setText(entry.getGlossesPreview());

    }

}
