package rs.rmt.notes.dto;

import rs.rmt.notes.domain.NoteEntity;

public class NoteExtDto {

    private String code;

    private String noteText;

    public NoteExtDto() {
    }

    public NoteExtDto(NoteEntity noteEntity) {
        this.code = noteEntity.getCode();
        this.noteText = noteEntity.getNoteText();
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
}
