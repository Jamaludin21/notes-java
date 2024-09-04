package com.study_case.notes.domain.usecase;

import com.study_case.notes.data.model.Note;
import com.study_case.notes.data.repository.NoteRepository;
import android.content.Context;

public class AddNoteUseCase {
    private final NoteRepository noteRepository;

    public AddNoteUseCase(Context context) {
        noteRepository = new NoteRepository(context);
    }

    public void execute(Note note) {
        noteRepository.insertNote(note);
    }
}
