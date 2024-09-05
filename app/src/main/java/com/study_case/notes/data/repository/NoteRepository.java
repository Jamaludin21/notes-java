package com.study_case.notes.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.study_case.notes.data.dao.NoteDao;
import com.study_case.notes.data.database.NoteDatabase;
import com.study_case.notes.data.model.Note;
import java.util.List;

public class NoteRepository {
    private final NoteDao noteDao;

    public NoteRepository(Context context) {
        NoteDatabase database = NoteDatabase.getInstance(context);
        noteDao = database.noteDao();
    }

    public void insertNote(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertNote(notes[0]);
            return null;
        }
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteDao.getAllNotes();
    }

    public void deleteNote(int id) {
        noteDao.deleteNoteById(id);
    }
}