package com.study_case.notes.domain.usecase;

import com.study_case.notes.data.model.Note;
import com.study_case.notes.data.repository.NoteRepository;
import android.content.Context;

import java.util.List;

public class GetNotesUseCase {
    private final NoteRepository noteRepository;

    public GetNotesUseCase(Context context) {
        noteRepository = new NoteRepository(context);
    }

    public List<Note> execute() {
        return (List<Note>) noteRepository.getAllNotes();
    }
}
