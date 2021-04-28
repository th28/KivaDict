package com.example.kivadict;

import android.app.Application;
import android.util.Log;

import androidx.paging.DataSource;

public class ExampleSentenceRepository {

    private WordDao wordDao;

    public ExampleSentenceRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
    }

    public DataSource.Factory<Integer, ExampleSentence> getExampleSentences(String word){
        word = String.format("\'%s\'",word);
        return wordDao.getExampleSentences(word);

    }


}
