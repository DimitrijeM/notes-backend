package rs.rmt.notes.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.rmt.notes.dao.UserRepository;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.dto.UserExtDto;
import rs.rmt.notes.dto.UserDto;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.service.UserService;

import java.util.ArrayList;

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
    public UserDto getUser(String username) {

        UserEntity userEntity = userRepository.findOne(username);
        return new UserDto(userEntity);
    }


    @Override
    public void updateUser(String username, UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.delete(username);
    }


    @Override
    public UserEntity checkUser(UserExtDto userDto) throws AuthorizationException{
        UserEntity user = userRepository.findOne(userDto.getUsername());

        if (user == null){
            throw new AuthorizationException("Login failed. Wrong username.");
        }

        if(!user.getPassword().equals(userDto.getPassword())){
            throw new AuthorizationException("Login failed. Wrong password.");
        }

        return user;
    }

}
