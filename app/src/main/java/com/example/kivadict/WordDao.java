package com.example.kivadict;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface WordDao {

    @Transaction
    @Query("SELECT words.* FROM words JOIN wordsFts ON words.id = wordsFts.docid WHERE wordsFts MATCH :searchQueryFI " +
            "UNION " +
            "SELECT words.* FROM words JOIN (SELECT glosses.* FROM glosses JOIN glossesFts ON glosses.id = glossesFts.docid WHERE glossesFts MATCH :searchQueryEN) as A ON A.word_id = words.id " +
            "UNION " + "SELECT words.* FROM words WHERE words.word IN (SELECT InflectionsFts.stem FROM InflectionsFts WHERE InflectionsFts.inflection MATCH :searchQueryINF) AND words.inflection IS NOT NULL"
            )
    DataSource.Factory<Integer, WordWithGlosses > getWordWithGlosses(String searchQueryFI, String searchQueryEN, String searchQueryINF);


    @Transaction
    @Query("SELECT fin_eng_examples.* FROM fin_eng_examples JOIN fin_eng_examplesFts ON fin_eng_examples.id = fin_eng_examplesFts.docid WHERE fin_eng_examplesFts MATCH :word")
    DataSource.Factory<Integer, ExampleSentence> getExampleSentences(String word);

}
//"SELECT words.* FROM words WHERE words.word IN (SELECT inflectionsFts.stem FROM inflectionsFts WHERE inflectionsFts.inflection MATCH :searchQueryINF) AND words.inflection IS NOT NULL"
//            "SELECT words.* FROM words JOIN (SELECT inflections.* FROM inflections JOIN inflectionFts on inflections.id = inflectionFts.docid WHERE inflectionFts.inflection MATCH :searchQueryINF) as B on  B.word_id = words.id")