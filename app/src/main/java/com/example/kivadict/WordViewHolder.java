package com.example.kivadict;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder{

    private final TextView wordItemView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.word_txt);
    }

    public void bind(String text) {

        wordItemView.setText(text);

    }

    static WordViewHolder create(ViewGroup parent){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_entry,parent,false);
        return new WordViewHolder(view);

    }
}
