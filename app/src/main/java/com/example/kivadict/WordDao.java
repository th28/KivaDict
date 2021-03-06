package com.example.kivadict;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface WordDao {



    @Transaction
    @Query("SELECT * FROM words WHERE word LIKE  :searchQuery || '%' " +
            "UNION " +
            "SELECT words.* FROM words  INNER JOIN glosses ON words.id = glosses.word_id WHERE glosses.gloss LIKE  :searchQuery || '%' ")
    DataSource.Factory<Integer, WordWithGlosses > getWordWithGlosses(String searchQuery);

}
/*
"SELECT * FROM words WHERE word LIKE  :searchQuery || '%' " +
        "UNION " +
        "SELECT words.* FROM words  INNER JOIN glosses ON words.id = glosses.word_id WHERE glosses.gloss LIKE  :searchQuery || '%' "
*/