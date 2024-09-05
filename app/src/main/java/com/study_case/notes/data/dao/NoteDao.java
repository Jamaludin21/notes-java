package com.study_case.notes.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.study_case.notes.data.model.Note;
import java.util.List;
import androidx.lifecycle.LiveData;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Note note);

    @Insert
    void insertAllNotes(List<Note> notes);

    @Update
    void updateNote(Note note);

    @Query("DELETE FROM notes WHERE id = :noteId")
    void deleteNoteById(int noteId);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT COUNT(*) FROM notes")
    int getNotesCount();
}
