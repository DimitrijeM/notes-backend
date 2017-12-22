package rs.rmt.notes.dto;


import org.springframework.stereotype.Component;
import rs.rmt.notes.domain.UserEntity;


public class UserDto {

    private String username;

    private String password;

    public UserDto() {
    }

    public UserDto(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
