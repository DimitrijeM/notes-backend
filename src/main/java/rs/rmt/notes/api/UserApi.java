package rs.rmt.notes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
 import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.service.UserService;

import java.util.List;


@RestController
public class UserApi {

    @Autowired
    UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void setUser(@RequestBody UserEntity userEntity){
        userService.setUser(userEntity);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserEntity getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable Long id, @RequestBody UserEntity userEntity){
        userService.updateUser(id, userEntity);
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteNote(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
