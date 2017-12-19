package rs.rmt.notes.service.util.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.rmt.notes.dao.NoteRepository;
import rs.rmt.notes.service.NoteService;
import rs.rmt.notes.service.util.NoteCodeService;

import java.util.GregorianCalendar;

@Service
public class NoteCodeServiceImpl implements NoteCodeService{

    @Autowired
    NoteService noteService;

    @Override
    public String generateCode(String text) {
        Long timestamp = new GregorianCalendar().getTimeInMillis();
        String code = timestamp + "";
        code = code.substring(0,6);
        code = text.substring(0, 2) + code + text.substring(text.length()-3, text.length()-1) ;
        System.out.println(code);

        if(noteService.getAllCodes().contains(code)){
            return generateCode(timestamp + text + timestamp + text.substring(2,3));
        }

        return code;
    }
}
