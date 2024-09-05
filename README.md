This is a simple Android Studio-based Notes application, developed on Java native. Local database storage involves the use of Room, SQLite, while the overall architecture follows MVVM.

Project Structure:

Note.java - single note with title and description
NoteDao.java - data access object that provides interaction with a database.
NoteRepository.java: This class will act as the intermediary between NoteDao and NoteViewModel. It is an abstraction layer that deals with database operations.
NoteViewModel.java: The class exposes the data and related methods of NoteRepository to MainActivity.
MainActivity.java: This lists notes and enables the user to add, edit, or delete a note.
AddNoteActivity.java: In this activity, users can create a new note.
NoteAdapter.java: Adapter for displaying the list of notes in MainActivity's RecyclerView.

Note: the view was already maximize with design BUT the list and function CRUD still buggy
