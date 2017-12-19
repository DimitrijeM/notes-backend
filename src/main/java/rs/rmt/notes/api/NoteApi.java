package rs.rmt.notes.api;


import com.itextpdf.text.DocumentException;
import org.apache.pdfbox.io.IOUtils;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.rmt.notes.consts.NotesConsts;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.dto.NoteExtDto;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.exceptions.CodeException;
import rs.rmt.notes.exceptions.FileLengthException;
import rs.rmt.notes.responses.NotesResponse;
import rs.rmt.notes.service.NoteService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
public class NoteApi {


    @Autowired
    NoteService noteService;


//    RestAPI

    @RequestMapping(value = "/user/{userId}/note", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    // C
    public NotesResponse setNote(@PathVariable Long userId, @RequestBody NoteDto noteDto) throws FileLengthException {
        String code = noteService.setNote(userId, noteDto);
        return new NotesResponse(code);
    }

    @RequestMapping(value = "/user/{userId}/note", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    // R
    public @ResponseBody
    List<NoteExtDto> getAllNotes(@PathVariable Long userId) throws Exception {
        return noteService.getAllNotes(userId);
    }

    @RequestMapping(value = "/user/{userId}/note/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    // R
    public @ResponseBody
    NoteDto getNote(@PathVariable String code) throws CodeException {
        return noteService.getNote(code);
    }

    @RequestMapping(value = "/user/{userId}/note/{code}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    // U
    public void updateNote(@PathVariable Long userId, @PathVariable String code, @RequestBody NoteDto noteDto) throws FileLengthException {
        noteService.setNote(userId, noteDto);
    }

    @RequestMapping(value = "/user/{userId}/note/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    // D
    public void deleteNote(@PathVariable Long userId, @PathVariable String code) {
        noteService.deleteNote(code);
    }




    @RequestMapping(value = "/user/{userId}/note-as-file/{code}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_PDF_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody FileSystemResource getFile(@PathVariable String code) throws CodeException, DocumentException, IOException {
        return new FileSystemResource(noteService.getNoteAsFile(code));
    }

}
