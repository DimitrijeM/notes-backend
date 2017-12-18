package rs.rmt.notes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.IterateBlock;

import rs.rmt.notes.dao.NoteRepository;
import rs.rmt.notes.dao.UserRepository;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.service.NoteService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    
    @Autowired
    UserRepository userRepository;

    @Override
    public void setNote(Long userId, NoteDto noteDto) {
    	UserEntity user = userRepository.findOne(userId);
    	NoteEntity noteEntity = new NoteEntity(noteDto);
    	noteEntity.setUser(user);
        noteRepository.save(noteEntity);

    }

    @Override
    public ArrayList<NoteDto> getAllNotes(Long userId) {
        Iterable<NoteEntity> noteEntities = noteRepository.findNoteEntitiesByUserId(userId);
        ArrayList<NoteDto> notes = new ArrayList<>();
        for (NoteEntity noteE : noteEntities){
            notes.add(new NoteDto(noteE));
        }
        return notes;
    }

    @Override
    public NoteDto getNote(Long code) {
        NoteEntity noteEntity = noteRepository.findOne(code);
        NoteDto note = new NoteDto(noteEntity);
        return note;
    }


//    @Override
//    public void updateNote(Long code, NoteEntity note) {
//        noteRepository.save(note);
//    }

    @Override
    public void deleteNote(Long code) {
        noteRepository.delete(code);
    }

}
