package de.ollie.webassistent.core.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Appointment;
import de.ollie.webassistent.core.model.User;
import de.ollie.webassistent.core.service.port.persistence.AppointmentPersistencePort;
import de.ollie.webassistent.core.service.AppointmentService;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated service interface implementation for Appointment management.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public abstract class AppointmentGeneratedServiceImpl implements AppointmentService {

	@Inject
	protected AppointmentPersistencePort persistencePort;

	@Override
	public Appointment create(Appointment model) {
		return persistencePort.create(model);
	}

	@Override
	public List<Appointment> findAll() {
		return persistencePort.findAll();
	}

	@Override
	public Page<Appointment> findAll(PageParameters pageParameters) {
		return persistencePort.findAll(pageParameters);
	}

	@Override
	public Optional<Appointment> findById(Long id) {
		return persistencePort.findById(id);
	}

	@Override
	public Appointment update(Appointment model) {
		return persistencePort.update(model);
	}

	@Override
	public void delete(Appointment model) {
		persistencePort.delete(model);
	}

	@Override
	public List<Appointment> findAllByUser(User user) {
		return persistencePort.findAllByUser(user);
	}

}