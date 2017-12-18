package rs.rmt.notes.service;


import org.springframework.stereotype.Service;
import rs.rmt.notes.domain.UserEntity;

import java.util.ArrayList;

@Service
public interface UserService {


    public void setUser(UserEntity user);

    public ArrayList<UserEntity> getAllUsers();

    public UserEntity getUser(Long id);

    public void updateUser(Long id, UserEntity user);

    public void deleteUser(Long id);

}
