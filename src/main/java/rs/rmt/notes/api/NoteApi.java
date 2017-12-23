package rs.rmt.notes.api;


import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.dto.NoteExtDto;
import rs.rmt.notes.exceptions.CodeException;
import rs.rmt.notes.service.NoteService;

import java.io.IOException;
import java.util.List;


@RestController
public class NoteApi {


    @Autowired
    NoteService noteService;

    @RequestMapping(value = "/user/{username}/note", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) // C
    public @ResponseBody NoteExtDto setNote(@PathVariable String username, @RequestBody NoteDto noteDto) throws Exception{
        NoteEntity note = noteService.setNote(username, noteDto);
        return new NoteExtDto(note);
    }

    @RequestMapping(value = "/user/{username}/note", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // R
    public @ResponseBody List<NoteExtDto> getAllNotes(@PathVariable String username) throws Exception {
        return noteService.getAllNotes(username);
    }

    @RequestMapping(value = "/user/{username}/note/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // R
    public @ResponseBody NoteDto getNote(@PathVariable String code) throws CodeException {
        return noteService.getNote(code);
    }

// U

    @RequestMapping(value = "/user/{username}/note/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    // D
    public void deleteNote(@PathVariable String username, @PathVariable String code) {
        noteService.deleteNote(code);
    }




    @RequestMapping(value = "/n-as-file/{code}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody FileSystemResource getFile(@PathVariable String code) throws CodeException, DocumentException, IOException {
        return new FileSystemResource(noteService.getNoteAsFile(code));
    }

}
