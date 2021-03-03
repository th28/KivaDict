package com.example.kivadict;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    MutableLiveData<String> searchQuery = new MutableLiveData<>("");


    private LiveData<List<Word>> searchQueryLive;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        searchQueryLive = Transformations.switchMap(searchQuery, s->wordRepository.getWords(s));
    }

    LiveData<List<Word>> getWords() { return searchQueryLive; }

}
