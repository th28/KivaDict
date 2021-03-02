package com.example.kivadict;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM words ORDER BY word ASC")
    LiveData<List<Word>>  getWords();


}
