package com.example.kivadict;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class WordExampleListAdapter extends PagedListAdapter<ExampleSentence, WordExampleViewHolder> {

    protected WordExampleListAdapter(@NonNull DiffUtil.ItemCallback<ExampleSentence> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public WordExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WordExampleViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull WordExampleViewHolder holder, int position) {

        ExampleSentence current = getItem(position);

        if (current != null){
            holder.bind(current);
        }
        else {
            holder.clear();
        }

    }

    static class SentenceDiff extends DiffUtil.ItemCallback<ExampleSentence> {

        @Override
        public boolean areItemsTheSame(@NonNull ExampleSentence oldItem, @NonNull ExampleSentence newItem) {
            if (oldItem.getSentence() == newItem.getSentence() && oldItem.getTranslate() == newItem.getTranslate()){
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public boolean areContentsTheSame(@NonNull ExampleSentence oldItem, @NonNull ExampleSentence newItem) {
            return true;
        }
    }
}
