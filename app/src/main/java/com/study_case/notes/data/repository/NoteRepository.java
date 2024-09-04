package com.study_case.notes.data.repository;

import android.content.Context;
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
        noteDao.insertNote(note);
    }

    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    public void deleteNote(int id) {
        noteDao.deleteNote(id);
    }
}