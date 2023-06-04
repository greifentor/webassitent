package de.ollie.webassistent.core.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Note;
import de.ollie.webassistent.core.model.User;
import de.ollie.webassistent.core.service.port.persistence.NotePersistencePort;
import de.ollie.webassistent.core.service.NoteService;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated service interface implementation for Note management.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public abstract class NoteGeneratedServiceImpl implements NoteService {

	@Inject
	protected NotePersistencePort persistencePort;

	@Override
	public Note create(Note model) {
		return persistencePort.create(model);
	}

	@Override
	public List<Note> findAll() {
		return persistencePort.findAll();
	}

	@Override
	public Page<Note> findAll(PageParameters pageParameters) {
		return persistencePort.findAll(pageParameters);
	}

	@Override
	public Optional<Note> findById(Long id) {
		return persistencePort.findById(id);
	}

	@Override
	public Note update(Note model) {
		return persistencePort.update(model);
	}

	@Override
	public void delete(Note model) {
		persistencePort.delete(model);
	}

	@Override
	public List<Note> findAllByUser(User user) {
		return persistencePort.findAllByUser(user);
	}

}