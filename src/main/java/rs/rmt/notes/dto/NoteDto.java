package rs.rmt.notes.dto;

import rs.rmt.notes.domain.NoteEntity;

public class NoteDto {
	
    private String noteText;

    public NoteDto() {
    }
    
    public NoteDto(NoteEntity noteEntity) {
    	this.noteText = noteEntity.getNoteText();
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    
}
