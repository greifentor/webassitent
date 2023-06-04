package de.ollie.webassistent.core.service.port.persistence;

import java.util.List;
import java.util.Optional;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Appointment;
import de.ollie.webassistent.core.model.User;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated persistence port interface for Appointment CRUD operations.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public interface AppointmentGeneratedPersistencePort {

	Appointment create(Appointment model);

	List<Appointment> findAll();

	Page<Appointment> findAll(PageParameters pageParameters);

	Optional<Appointment> findById(Long id);

	Appointment update(Appointment model);

	void delete(Appointment model);

	List<Appointment> findAllByUser(User user);

}