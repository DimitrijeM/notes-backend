package rs.rmt.notes.domain;

import javax.persistence.*;

@Entity
@Table(name="note")
public class NoteEntity {

    @Id
    @Column(name="id")
    private Long code;

    @Column(name="note_text")
    private String noteText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public NoteEntity() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
