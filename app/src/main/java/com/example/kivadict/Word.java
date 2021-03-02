package com.example.kivadict;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words")
public class Word {

    @PrimaryKey
    @NonNull
    private int id;
    private String word;
    private String inflection;
    @ColumnInfo(name = "pos")
    private String partOfSpeech;

    public Word(@NonNull int id, String word, String inflection, String partOfSpeech){
        this.id = id;
        this.word = word;
        this.inflection = inflection;
        this.partOfSpeech = partOfSpeech;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getInflection() {
        return inflection;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
