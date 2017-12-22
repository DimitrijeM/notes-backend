package rs.rmt.notes.service.util.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.rmt.notes.dao.NoteRepository;
import rs.rmt.notes.service.NoteService;
import rs.rmt.notes.service.util.NoteCodeService;

import java.util.GregorianCalendar;
import java.util.Random;

@Service
public class NoteCodeServiceImpl implements NoteCodeService{

    @Autowired
    NoteService noteService;

    @Override
    public String generateCode() {

        Random r = new Random();

        String numbers = "1234567890";
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";

        String code = "";

        for (int i = 0; i < 3; i++)
            code += numbers.charAt(r.nextInt(numbers.length()));

        for (int i = 0; i < 7; i++)
            code += alphabet.charAt(r.nextInt(alphabet.length()));

        System.out.println(code);

//        Long timestamp = new GregorianCalendar().getTimeInMillis();
//        code += timestamp ;
//        code = code.substring(0,6);
//        code = text.substring(0, 2) + code + text.substring(text.length()-3, text.length()-1) ;
//        System.out.println(code);



        if(noteService.getAllCodes().contains(code)){
            return generateCode();
        }

        return code;
    }
}
