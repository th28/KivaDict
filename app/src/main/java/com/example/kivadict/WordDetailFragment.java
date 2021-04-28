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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kivadict.R;

import org.w3c.dom.Text;

public class WordDetailFragment extends Fragment {

    private TextView wordText;
    private TextView posText;
    private TextView glossesText;
    private LinearLayout glossesList;

    public static final String ENTRY_KEY = "entry";


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
        WordWithGlosses entry = (WordWithGlosses) getArguments().getSerializable("entry");

        wordText = view.findViewById(R.id.detail_word);
        glossesList = view.findViewById(R.id.detail_meaning_list);
        posText = view.findViewById(R.id.detail_pos);
        wordText.setText(entry.getWord().getWord());
        posText.setText(entry.getWord().getPartOfSpeech());

        int i = 0;

        for (Gloss gloss : entry.getGlosses()){
            TextView glossText = new TextView(getContext());
            glossText.setText((i+1) + ". " + gloss.getGloss());
            glossesList.addView(glossText);
            i++;
        }


    }

}
