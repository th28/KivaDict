package com.example.kivadict;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "inflections")
public class Inflection {

    @PrimaryKey
    private int id;
    private String inflection;
    private String stem;
    private String detail;

    public Inflection(int id, String inflection, String stem, String detail) {
        this.id = id;
        this.inflection = inflection;
        this.stem = stem;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInflection() {
        return inflection;
    }

    public void setInflection(String inflection) {
        this.inflection = inflection;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
