package com.example.kivadict;


import androidx.room.Entity;
import androidx.room.Fts4;

@Fts4(contentEntity = ExampleSentence.class)
@Entity(tableName = "fin_eng_examplesFts")
public class ExampleSentenceFts {

    private String sentence;

    public ExampleSentenceFts(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
