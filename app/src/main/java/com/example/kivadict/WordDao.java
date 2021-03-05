package com.example.kivadict;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM words WHERE word LIKE  :searchQuery || '%'")
    DataSource.Factory<Integer, Word > getWords(String searchQuery);

    @Transaction
    @Query("SELECT * FROM words WHERE word LIKE  :searchQuery || '%'")
    DataSource.Factory<Integer, WordWithGlosses > getWordWithGlosses(String searchQuery);


}
