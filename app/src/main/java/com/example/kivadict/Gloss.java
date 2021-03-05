package com.example.kivadict;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "glosses")
public class Gloss {

    @PrimaryKey
    @NonNull
    private int id;
    @ColumnInfo(name = "word_id")
    private int wordId;
    private String gloss;

    public Gloss(int id, int wordId, String gloss) {
        this.id = id;
        this.wordId = wordId;
        this.gloss = gloss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }
}
