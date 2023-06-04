package de.ollie.webassistent.persistence;

import static de.ollie.webassistent.util.Check.ensure;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Note;
import de.ollie.webassistent.core.service.exception.NotNullConstraintViolationException;
import de.ollie.webassistent.core.service.port.persistence.NotePersistencePort;
import de.ollie.webassistent.persistence.converter.PageConverter;
import de.ollie.webassistent.persistence.converter.PageParametersToPageableConverter;
import de.ollie.webassistent.persistence.converter.NoteDBOConverter;
import de.ollie.webassistent.persistence.entity.NoteDBO;
import de.ollie.webassistent.persistence.repository.NoteDBORepository;
import de.ollie.webassistent.persistence.converter.UserDBOConverter;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated JPA persistence adapter for notes.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public abstract class NoteGeneratedJPAPersistenceAdapter implements NotePersistencePort {

	@Inject
	protected NoteDBOConverter converter;
	@Inject
	protected NoteDBORepository repository;
	@Inject
	protected UserDBOConverter userDBOConverter;

	@Inject
	protected PageParametersToPageableConverter pageParametersToPageableConverter;

	protected PageConverter<Note, NoteDBO> pageConverter;

	@PostConstruct
	public void postConstruct() {
		pageConverter = new PageConverter<>(converter);
	}

	@Override
	public Note create(Note model) {
		model.setId(-1);
		return converter.toModel(repository.save(converter.toDBO(model)));
	}

	@Override
	public List<Note> findAll() {
		return converter.toModel(repository.findAll());
	}

	@Override
	public Page<Note> findAll(PageParameters pageParameters) {
		return pageConverter.convert(repository.findAll(pageParametersToPageableConverter.convert(pageParameters)));
	}

	@Override
	public Optional<Note> findById(Long id) {
		return repository.findById(id).map(dbo -> converter.toModel(dbo));
	}

	@Override
	public Note update(Note model) {
		ensure(
				model.getUser() != null,
				() -> new NotNullConstraintViolationException("Note field user cannot be null.", "Note", "user"));
		ensure(
				model.getTitle() != null,
				() -> new NotNullConstraintViolationException("Note field title cannot be null.", "Note", "title"));
		return converter.toModel(repository.save(converter.toDBO(model)));
	}

	@Override
	public void delete(Note model) {
		repository.deleteById(model.getId());
	}

	@Override
	public List<Note> findAllByUser(User user) {
		return converter.toModel(repository.findAllByUser(userDBOConverter.toDBO(user)));
	}

}