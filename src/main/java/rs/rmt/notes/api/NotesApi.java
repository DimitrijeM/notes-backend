package rs.rmt.notes.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.NoteDto;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.responses.NotesResponse;
import rs.rmt.notes.service.NoteService;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class NotesApi {
	
	
    @Autowired
    NoteService noteService;

    
//    RestAPI
    
    @RequestMapping(value="/user/{userId}/note", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) // C
    public void setNote(@PathVariable Long userId, @RequestBody NoteDto noteDto){
        noteService.setNote(userId, noteDto);
    }

    @RequestMapping(value="/user/{userId}/note", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // R
    public @ResponseBody List<NoteDto> getAllNotes(@PathVariable Long userId){
        return noteService.getAllNotes(userId);
    }

    @RequestMapping(value="/user/{userId}/note/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // R
    public @ResponseBody NoteDto getNote(@PathVariable Long code){
        return noteService.getNote(code);
    }

    @RequestMapping(value="/user/{userId}/note/{code}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE) // U
    public void updateNote(@PathVariable Long userId, @PathVariable Long code, @RequestBody NoteDto noteDto){
        noteService.setNote(userId, noteDto);
    }

    @RequestMapping(value="/user/{userId}/note/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE) // D
    public void deleteNote(@PathVariable Long userId, @PathVariable Long code){
        noteService.deleteNote(code);
    }

}
