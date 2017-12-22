package rs.rmt.notes.service;


import org.springframework.stereotype.Service;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;

import java.util.ArrayList;

@Service
public interface UserService {


    public void setUser(UserEntity user) throws Exception;

    public ArrayList<UserEntity> getAllUsers();

    public UserEntity getUser(Long id);

    public void updateUser(Long id, UserEntity user);

    public void deleteUser(Long id);


    public UserDto checkUser(UserDto userDto)  throws AuthorizationException;

}
