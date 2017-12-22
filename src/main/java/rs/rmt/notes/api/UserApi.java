package rs.rmt.notes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
 import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.service.UserService;

import java.util.List;


@RestController
public class UserApi {

    @Autowired
    UserService userService;

    @RequestMapping(value="/user/register", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
    public void setUser(@RequestBody UserEntity userEntity) throws Exception{
//    public void setUser(@RequestBody String s) throws Exception{
//        System.out.println(s);
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
    public void updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity){
        userService.updateUser(id, userEntity);
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }




    @RequestMapping(value="/check-user/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto checkUser(@RequestBody UserDto userDto)  throws AuthorizationException {
        return userService.checkUser(userDto);
    }

}
