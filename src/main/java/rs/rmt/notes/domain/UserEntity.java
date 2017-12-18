package rs.rmt.notes.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

//    @OneToMany(mappedBy = "note")
//    private List<NoteEntity> notes;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public List<NoteEntity> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(List<NoteEntity> notes) {
//        this.notes = notes;
//    }
}
