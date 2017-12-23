package rs.rmt.notes.dto;

import rs.rmt.notes.domain.UserEntity;

public class UserDto {
    private String username;


    public UserDto() {
    }

    public UserDto(UserEntity userEntity) {
        this.username = userEntity.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
