package ru.astral.dao;

import ru.astral.entity.Note;

import java.util.List;

public interface NoteDao {

    void save(Note note);

    Note getById(int id);

    List<Note> findAll();

    void update(Note note);

    void delete(int id);

}