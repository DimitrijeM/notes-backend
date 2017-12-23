package rs.rmt.notes.service;


import org.springframework.stereotype.Service;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserExtDto;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;

import java.util.ArrayList;

@Service
public interface UserService {


    public void setUser(UserEntity user) throws Exception;

    public ArrayList<UserEntity> getAllUsers();

    public UserDto getUser(String username);

    public void updateUser(String username, UserEntity user);

    public void deleteUser(String username);


    public UserEntity checkUser(UserExtDto userDto)  throws AuthorizationException;

}
