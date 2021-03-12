package com.example.kivadict;

import androidx.room.Entity;
import androidx.room.Fts4;

@Fts4(contentEntity=Word.class)
@Entity(tableName = "wordsFts")
public class WordFts {

    private String word;

    public WordFts(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
