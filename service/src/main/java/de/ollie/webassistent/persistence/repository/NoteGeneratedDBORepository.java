package de.ollie.webassistent.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.ollie.webassistent.persistence.entity.NoteDBO;
import lombok.Generated;
import java.util.List;

import de.ollie.webassistent.persistence.entity.UserDBO;

/**
 * A generated JPA repository for notes.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Repository
public interface NoteGeneratedDBORepository extends JpaRepository<NoteDBO, Long> {

	List<NoteDBO> findAllByUser(UserDBO user);

}