package com.example.kivadict;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "glosses")
public class Gloss implements Serializable {

    @PrimaryKey
    @NonNull
    private int id;
    @ColumnInfo(name = "word_id",index = true)
    private int wordId;
    @ColumnInfo(index = true)
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
