package rs.rmt.notes.dto;

import rs.rmt.notes.domain.NoteEntity;

public class NoteDto {

	private Long code;
	
    private String noteText;

    public NoteDto() {
    }
    
    public NoteDto(NoteEntity noteEntity) {
    	this.code = noteEntity.getCode();
    	this.noteText = noteEntity.getNoteText();
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
    
    
    
}
