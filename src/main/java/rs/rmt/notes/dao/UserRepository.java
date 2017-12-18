package rs.rmt.notes.dao;

import org.springframework.data.repository.CrudRepository;
import rs.rmt.notes.domain.UserEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

//    findAll, findOne, save, delete

    public List<UserEntity> findByUsername(String username);
}
