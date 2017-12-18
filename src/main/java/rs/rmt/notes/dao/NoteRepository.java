package rs.rmt.notes.dao;

import org.springframework.data.repository.CrudRepository;
import rs.rmt.notes.domain.NoteEntity;

import java.util.List;

public interface NoteRepository extends CrudRepository<NoteEntity, Long> {

    public List<NoteEntity> findNoteEntitiesByUserId(Long id);
    
}
