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
    @Query("SELECT words.* FROM words JOIN wordsFts ON words.id = wordsFts.docid WHERE wordsFts MATCH :searchQueryFI " +
            "UNION " +
            "SELECT words.* FROM words JOIN (SELECT glosses.* FROM glosses JOIN glossesFts ON glosses.id = glossesFts.docid WHERE glossesFts MATCH :searchQueryEN) as A ON A.word_id = words.id " +
            "UNION " +
            "SELECT words.* from words WHERE words.word in (SELECT inflectionsFts.stem FROM inflectionsFts WHERE inflectionsFts.inflection MATCH :searchQueryINF) AND words.inflection IS NOT NULL")

    DataSource.Factory<Integer, WordWithGlosses > getWordWithGlosses(String searchQueryFI, String searchQueryEN, String searchQueryINF);

}
/*
"SELECT words.* FROM words JOIN wordsFts ON words.id = wordsFts.docid WHERE wordsFts MATCH '" + searchQueryFI + "' " +
        "UNION " +
        "SELECT words.* FROM words JOIN  (SELECT glosses.* FROM glosses JOIN glossesFts ON glosses.id = glossesFts.docid WHERE glossesFts MATCH '" + searchQueryEN + "') as A " +
        "ON A.word_id = words.id"
*/

/*
"SELECT * FROM words WHERE word LIKE  :searchQuery || '%' " +
        "UNION " +
        "SELECT words.* FROM words  INNER JOIN glosses ON words.id = glosses.word_id WHERE glosses.gloss LIKE  :searchQuery || '%' "
*/