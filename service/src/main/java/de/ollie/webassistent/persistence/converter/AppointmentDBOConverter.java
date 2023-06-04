package de.ollie.webassistent.persistence.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import lombok.Generated;
import lombok.RequiredArgsConstructor;

import de.ollie.webassistent.persistence.entity.AppointmentDBO;
import de.ollie.webassistent.core.model.Appointment;

/**
 * A DBO converter for appointments.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Named
@RequiredArgsConstructor
public class AppointmentDBOConverter implements ToModelConverter<Appointment, AppointmentDBO> {

	private final UserDBOConverter userDBOConverter;

	public AppointmentDBO toDBO(Appointment model) {
		if (model == null) {
			return null;
		}
		return new AppointmentDBO()
				.setId(model.getId())
				.setUser(userDBOConverter.toDBO(model.getUser()))
				.setTimeEnd(model.getTimeEnd())
				.setTimeStart(model.getTimeStart())
				.setTitle(model.getTitle());
	}

	@Override
	public Appointment toModel(AppointmentDBO dbo) {
		if (dbo == null) {
			return null;
		}
		return new Appointment()
				.setId(dbo.getId())
				.setUser(userDBOConverter.toModel(dbo.getUser()))
				.setTimeEnd(dbo.getTimeEnd())
				.setTimeStart(dbo.getTimeStart())
				.setTitle(dbo.getTitle());
	}

	@Override
	public List<Appointment> toModel(List<AppointmentDBO> dbos) {
		if (dbos == null) {
			return null;
		}
		return dbos.stream().map(this::toModel).collect(Collectors.toList());
	}

}