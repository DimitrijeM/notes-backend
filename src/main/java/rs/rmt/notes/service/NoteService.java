package rs.rmt.notes.service;


import org.springframework.stereotype.Service;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.responses.NotesResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public interface NoteService {

    public void setNote(Long userId, NoteDto noteDto);

    public ArrayList<NoteDto> getAllNotes(Long userId);

    public NoteDto getNote(Long code);

//    public void updateNote(Long code, NoteEntity note);

    public void deleteNote(Long code);



//    public ArrayList<NoteEntity> getNotesByUser(Long userId);


}
