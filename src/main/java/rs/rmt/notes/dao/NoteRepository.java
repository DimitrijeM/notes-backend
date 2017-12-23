package rs.rmt.notes.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rs.rmt.notes.domain.NoteEntity;

import java.util.List;

public interface NoteRepository extends CrudRepository<NoteEntity, String> {

    public List<NoteEntity> findNoteEntitiesByUserUsername(String username);

    @Query("SELECT n.code FROM #{#entityName} n")
    List<String> getAllCodes();
    
}
