package de.ollie.webassistent.persistence;

import static de.ollie.webassistent.util.Check.ensure;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Appointment;
import de.ollie.webassistent.core.service.exception.NotNullConstraintViolationException;
import de.ollie.webassistent.core.service.port.persistence.AppointmentPersistencePort;
import de.ollie.webassistent.persistence.converter.PageConverter;
import de.ollie.webassistent.persistence.converter.PageParametersToPageableConverter;
import de.ollie.webassistent.persistence.converter.AppointmentDBOConverter;
import de.ollie.webassistent.persistence.entity.AppointmentDBO;
import de.ollie.webassistent.persistence.repository.AppointmentDBORepository;
import de.ollie.webassistent.persistence.converter.UserDBOConverter;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated JPA persistence adapter for appointments.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public abstract class AppointmentGeneratedJPAPersistenceAdapter implements AppointmentPersistencePort {

	@Inject
	protected AppointmentDBOConverter converter;
	@Inject
	protected AppointmentDBORepository repository;
	@Inject
	protected UserDBOConverter userDBOConverter;

	@Inject
	protected PageParametersToPageableConverter pageParametersToPageableConverter;

	protected PageConverter<Appointment, AppointmentDBO> pageConverter;

	@PostConstruct
	public void postConstruct() {
		pageConverter = new PageConverter<>(converter);
	}

	@Override
	public Appointment create(Appointment model) {
		model.setId(-1);
		return converter.toModel(repository.save(converter.toDBO(model)));
	}

	@Override
	public List<Appointment> findAll() {
		return converter.toModel(repository.findAll());
	}

	@Override
	public Page<Appointment> findAll(PageParameters pageParameters) {
		return pageConverter.convert(repository.findAll(pageParametersToPageableConverter.convert(pageParameters)));
	}

	@Override
	public Optional<Appointment> findById(Long id) {
		return repository.findById(id).map(dbo -> converter.toModel(dbo));
	}

	@Override
	public Appointment update(Appointment model) {
		ensure(
				model.getUser() != null,
				() -> new NotNullConstraintViolationException("Appointment field user cannot be null.", "Appointment", "user"));
		ensure(
				model.getTimeStart() != null,
				() -> new NotNullConstraintViolationException("Appointment field timeStart cannot be null.", "Appointment", "timeStart"));
		ensure(
				model.getTitle() != null,
				() -> new NotNullConstraintViolationException("Appointment field title cannot be null.", "Appointment", "title"));
		return converter.toModel(repository.save(converter.toDBO(model)));
	}

	@Override
	public void delete(Appointment model) {
		repository.deleteById(model.getId());
	}

	@Override
	public List<Appointment> findAllByUser(User user) {
		return converter.toModel(repository.findAllByUser(userDBOConverter.toDBO(user)));
	}

}