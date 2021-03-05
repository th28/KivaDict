package com.example.kivadict;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    MutableLiveData<String> searchQuery = new MutableLiveData<>("#");
    LiveData<PagedList<WordWithGlosses>> wordList;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        if (searchQuery.getValue() != "") {
            wordList = Transformations.switchMap(searchQuery, live -> {
                return new LivePagedListBuilder<Integer, WordWithGlosses>(wordRepository.getWords(live), 20).build();
            });
        }

    }
}
