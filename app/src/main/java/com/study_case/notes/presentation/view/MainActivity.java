package com.study_case.notes.presentation.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;

import com.study_case.notes.R;
import com.study_case.notes.presentation.adapter.NoteAdapter;
import com.study_case.notes.presentation.viewmodel.NoteViewModel;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteAdapter = new NoteAdapter();

        recyclerView.setAdapter(noteAdapter);

        noteViewModel.getNotes().observe(this, notes -> {
            noteAdapter.setNotes(notes);
        });
    }
}
