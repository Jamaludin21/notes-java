package com.study_case.notes.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.study_case.notes.data.model.Note;
import com.study_case.notes.domain.usecase.AddNoteUseCase;
import com.study_case.notes.domain.usecase.DeleteNoteUseCase;
import com.study_case.notes.domain.usecase.GetNotesUseCase;
import com.study_case.notes.domain.usecase.UpdateNoteUseCase;
import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private AddNoteUseCase addNoteUseCase;
    private DeleteNoteUseCase deleteNoteUseCase;
    private GetNotesUseCase getNotesUseCase;
    private UpdateNoteUseCase updateNoteUseCase;

    private MutableLiveData<List<Note>> notesLiveData;

    public NoteViewModel(Application application) {
        super(application);
        addNoteUseCase = new AddNoteUseCase(application.getApplicationContext());
        deleteNoteUseCase = new DeleteNoteUseCase(application.getApplicationContext());
        getNotesUseCase = new GetNotesUseCase(application.getApplicationContext());
        updateNoteUseCase = new UpdateNoteUseCase(application.getApplicationContext());

        notesLiveData = new MutableLiveData<>();
    }

    public void addNote(Note note) {
        addNoteUseCase.execute(note);
    }

    public void deleteNote(int id) {
        deleteNoteUseCase.execute(id);
    }

    public LiveData<List<Note>> getNotes() {
        notesLiveData.setValue(getNotesUseCase.execute());
        return notesLiveData;
    }

    public void updateNote(Note note) {
        updateNoteUseCase.execute(note);
    }
}
