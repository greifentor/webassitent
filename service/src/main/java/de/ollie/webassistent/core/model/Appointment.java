package de.ollie.webassistent.core.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * A model for appointments.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Generated
@ToString(callSuper = true)
public class Appointment extends GeneratedAppointment {

	@Override
	public Appointment setId(long id) {
		super.setId(id);
		return this;
	}

	@Override
	public Appointment setUser(User user) {
		super.setUser(user);
		return this;
	}

	@Override
	public Appointment setTimeEnd(LocalDateTime timeEnd) {
		super.setTimeEnd(timeEnd);
		return this;
	}

	@Override
	public Appointment setTimeStart(LocalDateTime timeStart) {
		super.setTimeStart(timeStart);
		return this;
	}

	@Override
	public Appointment setTitle(String title) {
		super.setTitle(title);
		return this;
	}

}