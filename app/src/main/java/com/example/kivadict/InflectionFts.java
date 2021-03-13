package com.example.kivadict;
import androidx.room.Entity;
import androidx.room.Fts4;

@Fts4(contentEntity = Inflection.class)
@Entity(tableName = "inflectionsFts" )

public class InflectionFts {

    private String inflection;
    private String stem;

    public InflectionFts(String inflection) {
        this.inflection = inflection;
    }
    public String getInflection() {
        return inflection;
    }
    public void setInflection(String inflection) {
        this.inflection = inflection;
    }
    public String getStem() { return stem; }
    public void setStem(String stem) { this.stem = stem; }
}
