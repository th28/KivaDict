package com.example.kivadict;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WordWithGlosses implements Serializable {

    @Embedded
    public Word word;
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

    public List<Gloss> getGlosses() {

        return glosses;
    }

    public String getGlossesPreview() {

        StringBuilder sb = new StringBuilder();

        if (glosses.size() == 0) {
            return "";
        } else if (glosses.size() == 1) {
            return "1. " + glosses.get(0).getGloss();
        } else if (glosses.size() == 2) {
            for (int i = 0; i <= 1; i++) {
                sb.append(i + 1).append(". ").append(glosses.get(i).getGloss()).append("\n");
            }
            return sb.toString();
        } else {
            for (int i = 0; i <= 2; i++) {
                sb.append(i + 1).append(". ").append(glosses.get(i).getGloss()).append("\n");
            }
            return sb.toString();
        }

    }


}
