package com.codewithme.notesapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithme.notesapp.Model.Notes;
import com.codewithme.notesapp.Service.NotesService;

@RestController
@RequestMapping("notes")
public class NotesController {

    @Autowired
    NotesService notesService;

    @GetMapping("get")
    public List<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }

    @PostMapping("create")
    public String createNote(@RequestBody Notes note){
        return notesService.createNote(note);
    }

    @DeleteMapping("delete/{id}")
    public String deleteNoteById(@PathVariable("id") Integer id){
        return notesService.deleteNoteById(id);
    }

    @PutMapping("update/{id}")
    public String updateNote(@PathVariable Integer id, @RequestBody Notes note){
        return notesService.updateNote(id, note);
    }
    
    
}
