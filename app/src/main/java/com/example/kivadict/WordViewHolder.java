package com.example.kivadict;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView wordItemView;
    private final TextView posTextView;
    private final TextView glossesTextView;

    private WordWithGlosses wordWithGlosses;
    private WordViewModel wordViewModel;
    private OnItemClickListener listener;

    public WordViewHolder(@NonNull View itemView, OnItemClickListener listener, WordViewModel wordViewModel) {
        super(itemView);
        this.wordItemView = itemView.findViewById(R.id.word_txt);
        this.posTextView = itemView.findViewById(R.id.pos_text);
        this.glossesTextView = itemView.findViewById(R.id.glosses_list);

        this.listener = listener;
        this.wordViewModel = wordViewModel;
        itemView.setOnClickListener(this);
    }

    public void bind(WordWithGlosses entry) {

        wordWithGlosses = entry;
        wordItemView.setText(entry.getWord().getWord());
        posTextView.setText(entry.getWord().getPartOfSpeech());
        glossesTextView.setText(entry.getGlossesPreview());

    }

    public void clear() {
        wordItemView.setText("Loading");
        posTextView.setText("Loading");
        glossesTextView.setText("Loading");

    }

    static WordViewHolder create(ViewGroup parent, OnItemClickListener listener, WordViewModel wordViewModel) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_entry, parent, false);
        return new WordViewHolder(view, listener, wordViewModel);

    }

    @Override
    public void onClick(View v) {
        Log.d("wtf", "Word: " + wordWithGlosses.getWord().getWord() + "adap pos: " +
                this.getAdapterPosition() + "layout pos: " + this.getLayoutPosition());
        listener.onItemClick(wordWithGlosses);

    }


}
