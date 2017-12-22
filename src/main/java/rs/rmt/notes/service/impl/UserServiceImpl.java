package rs.rmt.notes.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.rmt.notes.dao.UserRepository;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public void setUser(UserEntity user) throws Exception {
        userRepository.save(user);
    }

    @Override
    public ArrayList<UserEntity> getAllUsers() {
        Iterable<UserEntity> usersI = userRepository.findAll();
        ArrayList<UserEntity> users = new ArrayList<UserEntity>();
        for (UserEntity userI : usersI){
            users.add(userI);
        }
        return users;
    }

    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findOne(id);
    }


    @Override
    public void updateUser(Long id, UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }


    @Override
    public UserDto checkUser(UserDto userDto) throws AuthorizationException{
        List<UserEntity> users = userRepository.findByUsername(userDto.getUsername());

        if (users == null || users.isEmpty() || users.size() > 1
                ){
            throw new AuthorizationException("Login failed. Wrong username.");
        }

        UserEntity userEntity = users.get(0);

        if(!userEntity.getPassword().equals(userDto.getPassword())){
            throw new AuthorizationException("Login failed. Wrong password.");
        }

        return userDto;
    }

}
