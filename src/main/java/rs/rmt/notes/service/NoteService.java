package rs.rmt.notes.service;


import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.dto.NoteExtDto;
import rs.rmt.notes.exceptions.CodeException;
import rs.rmt.notes.exceptions.FileLengthException;
import rs.rmt.notes.responses.NotesResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public interface NoteService {

    public NoteEntity setNote(String username, NoteDto noteDto) throws FileLengthException;

    public ArrayList<NoteExtDto> getAllNotes(String username);

    public NoteDto getNote(String code) throws CodeException;

    public void updateNote(NoteExtDto note);

    public void deleteNote(String code);



    public List<String> getAllCodes();




    public File getFileFor(String fileName);

    public File getNoteAsFile(String code) throws CodeException, DocumentException, IOException;

//    public ArrayList<NoteEntity> getNotesByUser(Long userId);


}
