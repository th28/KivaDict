package com.example.kivadict;

import android.app.Application;

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

    DataSource.Factory<Integer, Word > getWords(String s) {

        return wordDao.getWords(s);

    }

}
