package de.ollie.webassistent.core.service;

import java.util.List;
import java.util.Optional;

import de.ollie.webassistent.core.model.Page;
import de.ollie.webassistent.core.model.PageParameters;
import de.ollie.webassistent.core.model.Appointment;
import de.ollie.webassistent.core.model.User;
import lombok.Generated;

import de.ollie.webassistent.core.model.User;

/**
 * A generated service interface for Appointment management.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public interface AppointmentGeneratedService {

	Appointment create(Appointment model);

	List<Appointment> findAll();

	Page<Appointment> findAll(PageParameters pageParameters);

	Optional<Appointment> findById(Long id);

	Appointment update(Appointment model);

	void delete(Appointment model);

	List<Appointment> findAllByUser(User user);

}