package com.example.kivadict;

import androidx.room.Entity;
import androidx.room.Fts4;

@Fts4(contentEntity=Gloss.class)
@Entity(tableName = "glossesFts")
public class GlossFts {

    private String gloss;

    public GlossFts(String gloss){

        this.gloss = gloss;

    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }
}
