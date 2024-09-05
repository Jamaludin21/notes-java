package com.study_case.notes.data.database;

import com.study_case.notes.data.dao.NoteDao;
import com.study_case.notes.data.model.Note;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS notes (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT, description TEXT, created_at INTEGER NOT NULL DEFAULT 0)");
            Executors.newSingleThreadExecutor().execute(() -> {
                insertDummyData(instance);
            });
        }
    };

    public abstract NoteDao noteDao();

    private static NoteDatabase instance;

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "notes.db")
                    .addMigrations(MIGRATION_1_2)
                    .build();

            // Use a coroutine to access the database on a background thread
            new Thread(() -> {
                if (instance.noteDao().getNotesCount() == 0) {
                    insertDummyData(instance);
                }
            }).start();
        }
        return instance;
    }

    private static void insertDummyData(NoteDatabase database) {
        List<Note> notes = new ArrayList<>();

        notes.add(new Note("Agenda Senin", "Weekly briefing dengan tim product"));
        notes.add(new Note("Agenda Rabu", "Meetup client BPJS"));
        notes.add(new Note("Agenda Jumat", "Weekly Brifing All Team Company"));

        database.noteDao().insertAllNotes(notes);
    }
}

