package de.ollie.webassistent.core.service;

import java.util.List;
import java.util.Optional;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Note;
import de.ollie.webassistent.core.model.User;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated service interface for Note management.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public interface NoteGeneratedService {

	Note create(Note model);

	List<Note> findAll();

	Page<Note> findAll(PageParameters pageParameters);

	Optional<Note> findById(Long id);

	Note update(Note model);

	void delete(Note model);

	List<Note> findAllByUser(User user);

}