package rs.rmt.notes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
 import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserExtDto;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.responses.NotesResponse;
import rs.rmt.notes.service.UserService;

import java.util.List;


@RestController
public class UserApi {

// api tutorial
    @RequestMapping(value = "/hello-{name}", method = RequestMethod.GET)
    public @ResponseBody
    String hello(@PathVariable String name){
        return "hello" + name;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    NotesResponse hello(@RequestBody UserExtDto user){
        NotesResponse response = new NotesResponse();
        response.setCode("hello " + user.getUsername());
        return response;
    }


// end




    @Autowired
    UserService userService;

    @RequestMapping(value="/user/register", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
    public void setUser(@RequestBody UserEntity userEntity) throws Exception{
        userService.setUser(userEntity);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/user/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    UserDto getUser(@PathVariable String username){
        return userService.getUser(username);
    }

//    @RequestMapping(value="/user/{username}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public void updateUser(@PathVariable String username, @RequestBody UserEntity userEntity){
//        userService.updateUser(username, userEntity);
//    }

    @RequestMapping(value="/user/{username}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }


    @RequestMapping(value="/check-user/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserEntity checkUser(@RequestBody UserExtDto userDto)  throws AuthorizationException {
        return userService.checkUser(userDto);
    }

}
