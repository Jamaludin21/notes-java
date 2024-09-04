package com.study_case.notes.data.dao;
import com.study_case.notes.data.model.Note;
import java.util.List;

public interface NoteDao {
    void insertNote(Note note);

    void updateNote(Note note);

    void deleteNote(int note);

    List<Note> getAllNotes();
}
