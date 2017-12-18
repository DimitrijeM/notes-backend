package rs.rmt.notes.service;


import org.springframework.stereotype.Service;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.responses.NotesResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public interface NoteService {

    public void setNote(NoteEntity note);

    public ArrayList<NoteEntity> getAllNotes();

    public NoteEntity getNote(Long code);

    public void updateNote(Long code, NoteEntity note);

    public void deleteNote(Long code);



    public ArrayList<NoteEntity> getNotesByUser(Long userId);


}
