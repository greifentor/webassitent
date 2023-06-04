package de.ollie.webassistent.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.ollie.webassistent.persistence.entity.AppointmentDBO;
import lombok.Generated;
import java.util.List;

import de.ollie.webassistent.persistence.entity.UserDBO;

/**
 * A generated JPA repository for appointments.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Repository
public interface AppointmentGeneratedDBORepository extends JpaRepository<AppointmentDBO, Long> {

	List<AppointmentDBO> findAllByUser(UserDBO user);

}