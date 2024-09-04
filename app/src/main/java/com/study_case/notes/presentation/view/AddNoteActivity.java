package com.study_case.notes.presentation.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.study_case.notes.R;
import com.study_case.notes.data.model.Note;
import com.study_case.notes.presentation.viewmodel.NoteViewModel;

public class AddNoteActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
    }

    public void addNote(Note note) {
        noteViewModel.addNote(note);
    }
}
