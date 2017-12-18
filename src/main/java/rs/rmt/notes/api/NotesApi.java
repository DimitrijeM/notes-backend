package rs.rmt.notes.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.rmt.notes.domain.NoteEntity;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.responses.NotesResponse;
import rs.rmt.notes.service.NoteService;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class NotesApi {
	
	
//  @RequestMapping(value="/hello", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//  public @ResponseBody NotesResponse hello1(@RequestBody UserEntity user){
//	  String message1 = "";
//	  
//      if (user.getPassword().equals("123")) {
//    	  message1 = "hello " + user.getUsername();
//      }
//      else {
//    	  message1 = "login failed";
//      }
//      
//      NotesResponse response = new NotesResponse();
//      response.setMessage(message1);
//      
//      return response;
//  }
	
	

////    @RequestMapping("/hello")
//    @RequestMapping(value="/notes-{name}-{password}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
//    public @ResponseBody String hello(@PathVariable(name = "name") String name, @PathVariable String password){
//        if (password.equals("123"))
//            return "hello " + name;
//        return "error";
//    }
//
//    @RequestMapping(value="/notes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody NotesResponse hello(@RequestBody UserDto user){
//        if (user.getPassword().equals("123"))
//            return new NotesResponse(("hello " + user.getUsername() + "/nLogin successfull."));
//        return new NotesResponse("error");
//    }





    //rest api Beleske CRUD 

//    @Resource(name = "noteService")
    @Autowired
    NoteService noteService;

    @RequestMapping(value="/note", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) // C
    public void setNote(@RequestBody NoteEntity noteEntity){
        noteService.setNote(noteEntity);
    }

    @RequestMapping(value="/note", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<NoteEntity> getAllNotes(){
        return noteService.getAllNotes();
    }

    @RequestMapping(value="/note/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody NoteEntity getNote(@PathVariable Long code){
        return noteService.getNote(code);
    }

    @RequestMapping(value="/note/{code}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable Long code, @RequestBody NoteEntity noteEntity){
        noteService.updateNote(code, noteEntity);
    }

    @RequestMapping(value="/note/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteNote(@PathVariable Long code){
        noteService.deleteNote(code);
    }

}
