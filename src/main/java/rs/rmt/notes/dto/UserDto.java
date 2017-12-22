package rs.rmt.notes.dto;

import rs.rmt.notes.domain.UserEntity;

public class UserDto2 {
    private String username;


    public UserDto2() {
    }

    public UserDto2(UserEntity userEntity) {
        this.username = userEntity.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
