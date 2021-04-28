package com.example.kivadict;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class, Gloss.class, Inflection.class, WordFts.class,
        GlossFts.class, InflectionsFts.class, ExampleSentence.class, ExampleSentenceFts.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static volatile WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "words")
                            .createFromAsset("db/dict1.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
