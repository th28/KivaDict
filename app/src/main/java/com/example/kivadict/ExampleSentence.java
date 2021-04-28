package com.example.kivadict;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fin_eng_examples")
public class ExampleSentence {

    @PrimaryKey
    private Integer id;
    private String sentence;
    private String translate;

    public ExampleSentence(String sentence, String translate){
        this.sentence = sentence;
        this.translate = translate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}
