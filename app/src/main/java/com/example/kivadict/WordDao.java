package com.example.kivadict;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM words WHERE word LIKE '%' || :searchQuery || '%' ")
    LiveData<List<Word>>  getWords(String searchQuery);


}
