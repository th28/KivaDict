package com.example.kivadict;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordViewHolder extends RecyclerView.ViewHolder{

    private final TextView wordItemView;
    private final TextView posTextView;
    private final TextView glossesTextView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.word_txt);
        posTextView = itemView.findViewById(R.id.pos_text);
        glossesTextView = itemView.findViewById(R.id.glosses_list);
    }

    public void bind(String wordText, String posText, String glossListText) {

        wordItemView.setText(wordText);
        posTextView.setText(posText);
        glossesTextView.setText(glossListText);

    }

    static WordViewHolder create(ViewGroup parent){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_entry,parent,false);
        return new WordViewHolder(view);

    }
}
