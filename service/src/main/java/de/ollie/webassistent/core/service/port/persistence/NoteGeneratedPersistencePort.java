package de.ollie.webassistent.core.service.port.persistence;

import java.util.List;
import java.util.Optional;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Note;
import de.ollie.webassistent.core.model.User;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated persistence port interface for Note CRUD operations.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public interface NoteGeneratedPersistencePort {

	Note create(Note model);

	List<Note> findAll();

	Page<Note> findAll(PageParameters pageParameters);

	Optional<Note> findById(Long id);

	Note update(Note model);

	void delete(Note model);

	List<Note> findAllByUser(User user);

}