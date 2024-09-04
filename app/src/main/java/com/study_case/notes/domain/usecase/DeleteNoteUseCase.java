package com.study_case.notes.domain.usecase;

import com.study_case.notes.data.repository.NoteRepository;
import android.content.Context;

public class DeleteNoteUseCase {
    private final NoteRepository noteRepository;

    public DeleteNoteUseCase(Context context) {
        noteRepository = new NoteRepository(context);
    }

    public void execute(int id) {
        noteRepository.deleteNote(id);
    }
}
