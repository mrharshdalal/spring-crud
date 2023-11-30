package com.codewithme.notesapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithme.notesapp.Dao.NotesDao;
import com.codewithme.notesapp.Model.Notes;

@Service
public class NotesService {

    @Autowired
    NotesDao notesDao;

    public List<Notes> getAllNotes() {
        return notesDao.findAll();
    }

    public String createNote(Notes note) {
        notesDao.save(note);
        return "Creating note successful";
    }

    public String deleteNoteById(Integer id) {
        notesDao.deleteById(id);
        return "Deleting note successful";
    }

    public String updateNote(Integer id, Notes updatedNote) {
        Optional<Notes> note = notesDao.findById(id);

        if(note.isPresent()){
            Notes existingNote = note.get();
            existingNote.setTitle(updatedNote.getTitle());
            existingNote.setContent(updatedNote.getContent());
            notesDao.save(existingNote);
            return "Updating Note Successful";

        }
        return "null";
    }
    
}
