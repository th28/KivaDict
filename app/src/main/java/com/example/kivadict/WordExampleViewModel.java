package com.example.kivadict;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.kivadict.ExampleSentence;
import com.example.kivadict.ExampleSentenceRepository;
import com.example.kivadict.WordWithGlosses;

public class WordExampleViewModel extends AndroidViewModel {

    private ExampleSentenceRepository exampleSentenceRepository;
    MutableLiveData<String> word = new MutableLiveData<>("");
    LiveData<PagedList<ExampleSentence>> exampleSentencesList;

    public WordExampleViewModel(@NonNull Application application) {
        super(application);
        exampleSentenceRepository = new ExampleSentenceRepository(application);
        exampleSentencesList = Transformations.switchMap(word,live -> {
            return new LivePagedListBuilder<Integer, ExampleSentence>
                    (exampleSentenceRepository.getExampleSentences(live), 10).build(); });
    }

}
