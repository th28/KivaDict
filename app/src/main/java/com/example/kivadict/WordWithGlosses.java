package com.example.kivadict;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class WordWithGlosses {

    @Embedded public Word word;
    @Relation(
            parentColumn = "id",
            entityColumn = "word_id"
    )
    public List<Gloss> glosses;

    public WordWithGlosses(Word word, List<Gloss> glosses) {
        this.word = word;
        this.glosses = glosses;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public List<Gloss> getGlosses() {

        return glosses;

    }

    public String getGlossesPreview(){

        StringBuilder sb = new StringBuilder();

        for (Gloss gloss: glosses){

            sb.append(gloss.getGloss());
            sb.append("\n");

        }

        return sb.toString();

    }

    public void setGlosses(List<Gloss> glosses) {
        this.glosses = glosses;
    }
}
