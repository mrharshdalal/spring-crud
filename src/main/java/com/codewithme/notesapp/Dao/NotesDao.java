package com.codewithme.notesapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithme.notesapp.Model.Notes;

@Repository
public interface NotesDao extends JpaRepository<Notes, Integer>{

    void deleteById(Integer id);
    
}
