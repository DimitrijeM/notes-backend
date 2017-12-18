package rs.rmt.notes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.rmt.notes.dao.NoteRepository;
import rs.rmt.notes.dao.UserRepository;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.service.NoteService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

	

	
//    ArrayList<NoteEntity> notes = new ArrayList<>();

    @Autowired
    NoteRepository noteRepository;


    @Override
    public void setNote(NoteEntity note) {
//        notes.add(note);
        noteRepository.save(note);

    }

    @Override
    public ArrayList<NoteEntity> getAllNotes() {
//        return notes;
        Iterable<NoteEntity> notesI = noteRepository.findAll();
        ArrayList<NoteEntity> notes = new ArrayList<NoteEntity>();
        for (NoteEntity noteI : notesI){
            notes.add(noteI);
        }
        return notes;
    }

    @Override
    public NoteEntity getNote(Long code) {
//        for(int i = 0; i < notes.size(); i++){
//            if(notes.get(i).getCode() == code)
//                return notes.get(i);
//        }
//        return null;
        return noteRepository.findOne(code);
    }


    @Override
    public void updateNote(Long code, NoteEntity note) {
//        for(int i = 0; i < notes.size(); i++){
//            if(notes.get(i).getCode() == code){
//                notes.set(i, note);
//            }
//        }
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long code) {
//        for(int i = 0; i < notes.size(); i++){
//            if(notes.get(i).getCode() == code){
//                notes.remove(i);
//            }
//        }
        noteRepository.delete(code);
    }


    @Override
    public ArrayList<NoteEntity> getNotesByUser(Long userId) {
        Iterable<NoteEntity> notesI = noteRepository.findNoteEntitiesByUserId(userId);
        ArrayList<NoteEntity> notes = new ArrayList<NoteEntity>();
        for (NoteEntity noteI : notesI){
            notes.add(noteI);
        }
        return notes;
    }
}
