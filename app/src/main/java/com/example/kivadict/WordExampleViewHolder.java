package com.example.kivadict;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordExampleViewHolder extends RecyclerView.ViewHolder {

    private final TextView exampleSentenceView;
    private final TextView translateView;


    public WordExampleViewHolder(@NonNull View itemView) {
        super(itemView);
        this.exampleSentenceView = itemView.findViewById(R.id.fi_example);
        this.translateView = itemView.findViewById(R.id.en_example);
    }


    void bind(ExampleSentence example){

        exampleSentenceView.setText(example.getSentence());
        translateView.setText(example.getTranslate());

    }

    void clear(){

        exampleSentenceView.setText("Loading");
        translateView.setText("Loading");

    }

    static WordExampleViewHolder create(ViewGroup parent){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_entry,parent, false);
        return new WordExampleViewHolder(view);


    }
}
