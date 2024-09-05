package com.study_case.notes.presentation.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.study_case.notes.R;
import com.study_case.notes.data.model.Note;
import com.study_case.notes.presentation.viewmodel.NoteViewModel;

public class AddNoteActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private EditText etTitle;
    private EditText etContent;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        btnSave = findViewById(R.id.btn_save);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString();
            String content = etContent.getText().toString();

            Note note = new Note(title, content);
            addNote(note);
            noteViewModel.refreshNotes();
        });
    }

    public void addNote(Note note) {
        noteViewModel.addNote(note);
    }
}
