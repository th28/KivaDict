package com.example.kivadict;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class WordListAdapter extends PagedListAdapter<WordWithGlosses, WordViewHolder> {

    private OnItemClickListener listener;
    private WordViewModel wordViewModel;

    protected WordListAdapter(@NonNull DiffUtil.ItemCallback<WordWithGlosses> diffCallback, OnItemClickListener listener, WordViewModel wordViewModel) {
        super(diffCallback);
        this.listener = listener;
        this.wordViewModel = wordViewModel;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent, listener, wordViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        WordWithGlosses current = getItem(position);

        //holder.setIsRecyclable(false);

        if (current != null) {
            holder.bind(current);
        }
        else{
            holder.clear();
        }

    }
    static class WordDiff extends DiffUtil.ItemCallback<WordWithGlosses> {

        @Override
        public boolean areItemsTheSame(@NonNull WordWithGlosses oldItem, @NonNull WordWithGlosses newItem) {
            return oldItem.getWord().getId() == newItem.getWord().getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull WordWithGlosses oldItem, @NonNull WordWithGlosses newItem) {
            return true;
        }
    }

}
