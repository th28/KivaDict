package com.example.kivadict;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class WordListAdapter extends PagedListAdapter<WordWithGlosses, WordViewHolder> {


    protected WordListAdapter(@NonNull DiffUtil.ItemCallback<WordWithGlosses> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        WordWithGlosses current = getItem(position);


        if (current != null) {
            holder.bind(current.getWord().getWord(),current.getWord().getPartOfSpeech(),current.getGlossesPreview());
        }
        else{
            ArrayList<String> LoadingGlosses = new ArrayList<>();
            LoadingGlosses.add("Loading");
            LoadingGlosses.add("Loading");
            LoadingGlosses.add("Loading");
            holder.bind("Loading","Loading", null);
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
