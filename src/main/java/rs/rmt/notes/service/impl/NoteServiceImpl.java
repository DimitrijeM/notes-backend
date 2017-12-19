package rs.rmt.notes.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.rmt.notes.consts.NotesConsts;
import rs.rmt.notes.dao.NoteRepository;
import rs.rmt.notes.dao.UserRepository;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.dto.NoteExtDto;
import rs.rmt.notes.exceptions.CodeException;
import rs.rmt.notes.exceptions.FileLengthException;
import rs.rmt.notes.service.NoteService;
import rs.rmt.notes.service.util.NoteCodeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    
    @Autowired
    UserRepository userRepository;


    @Autowired
    NoteCodeService noteCodeService;

    @Override
    public String setNote(Long userId, NoteDto noteDto) throws FileLengthException {
    	UserEntity user = userRepository.findOne(userId);

    	if(noteDto.getNoteText().length() > 500) {
    	    throw new FileLengthException("Max file length is 500 chars.");
        }
    	NoteEntity noteEntity = new NoteEntity(noteDto);
    	String code = noteCodeService.generateCode(noteDto.getNoteText());
    	noteEntity.setCode(code);

    	noteEntity.setUser(user);
        noteRepository.save(noteEntity);

        return code;
    }

    @Override
    public ArrayList<NoteExtDto> getAllNotes(Long userId) {
        Iterable<NoteEntity> noteEntities = noteRepository.findNoteEntitiesByUserId(userId);
        ArrayList<NoteExtDto> notes = new ArrayList<>();
        for (NoteEntity noteE : noteEntities){
            notes.add(new NoteExtDto(noteE));
        }
        return notes;
    }

    @Override
    public NoteDto getNote(String code) throws CodeException{
        NoteEntity noteEntity = noteRepository.findOne(code);
        if(noteEntity == null) throw new CodeException("Note with this code doesn't exist.");

        NoteDto note = new NoteDto(noteEntity);
        return note;
    }


//    @Override
//    public void updateNote(Long code, NoteEntity note) {
//        noteRepository.save(note);
//    }

    @Override
    public void deleteNote(String code) {
        noteRepository.delete(code);
    }



    public List<String> getAllCodes(){
        return noteRepository.getAllCodes();
    }




    public File getFileFor(String fileName){
        String path = System.getProperty("user.dir") + "/" + fileName + ".pdf";
        System.out.println(path);
        return new File(path);
    }


    public File getNoteAsFile(String code) throws DocumentException, IOException{
        NoteEntity noteEntity = noteRepository.findOne(code);
//        if(noteEntity == null) throw new CodeException("Note with this code doesn't exist.");

        String filePath = NotesConsts.FIlE_DIR + code + NotesConsts.TXT_EXT;

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        Paragraph paragraph;
        if(noteEntity == null) paragraph = new Paragraph("Error: Wrong code!\nNote with this code doesn't exist.");
        else paragraph = new Paragraph(noteEntity.getNoteText());

        document.add(paragraph);
        document.close();

        return new File(filePath);
    }

}
