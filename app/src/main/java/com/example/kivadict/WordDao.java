package com.example.kivadict;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM words WHERE word LIKE  :searchQuery || '%'")
    DataSource.Factory<Integer, Word > getWords(String searchQuery);


}
