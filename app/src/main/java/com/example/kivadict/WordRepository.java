package com.example.kivadict;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> myWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
    }

    DataSource.Factory<Integer, WordWithGlosses> getWords(String searchQuery) {
       String searchQueryFI =  String.format("\"^%s*\"",searchQuery);
       Log.d("d",searchQueryFI);

       String searchQueryEN =  String.format("\"%s\"",searchQuery);
        Log.d("d",searchQueryEN);
       return wordDao.getWordWithGlosses(searchQueryFI,searchQueryEN);
    }


}
