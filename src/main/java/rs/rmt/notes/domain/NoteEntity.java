package rs.rmt.notes.domain;

import javax.persistence.*;

import rs.rmt.notes.dto.NoteDto;

@Entity
@Table(name="note")
public class NoteEntity {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="note_text", length = 500)
    private String noteText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public NoteEntity() {
    }
    
    public NoteEntity(NoteDto note) {
    	this.noteText = note.getNoteText();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
