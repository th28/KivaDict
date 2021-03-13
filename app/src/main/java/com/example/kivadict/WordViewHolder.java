package com.example.kivadict;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final TextView wordItemView;
    private final TextView posTextView;
    private final TextView glossesTextView;
    private WordWithGlosses wordWithGlosses;
    private OnItemClickListener listener;

    public WordViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.wordItemView = itemView.findViewById(R.id.word_txt);
        this.posTextView = itemView.findViewById(R.id.pos_text);
        this.glossesTextView = itemView.findViewById(R.id.glosses_list);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind(WordWithGlosses entry) {

        wordWithGlosses = entry;
        wordItemView.setText(entry.getWord().getWord());
        posTextView.setText(entry.getWord().getPartOfSpeech());
        glossesTextView.setText(entry.getGlossesPreview());

    }

    public void clear(){

        wordItemView.setText("Loading");
        posTextView.setText("Loading");
        glossesTextView.setText("Loading");

    }

    static WordViewHolder create(ViewGroup parent, OnItemClickListener listener){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_entry,parent,false);
        return new WordViewHolder(view, listener);

    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(wordWithGlosses);
    }



}
