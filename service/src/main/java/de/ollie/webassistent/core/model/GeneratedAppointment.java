package de.ollie.webassistent.core.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Generated;
import lombok.experimental.Accessors;

/**
 * A model for appointments.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Accessors(chain = true)
@Data
@Generated
public class GeneratedAppointment {

	public static final String ID = "ID";
	public static final String USER = "USER";
	public static final String TIMEEND = "TIMEEND";
	public static final String TIMESTART = "TIMESTART";
	public static final String TITLE = "TITLE";

	private long id;
	private User user;
	private LocalDateTime timeEnd;
	private LocalDateTime timeStart;
	private String title;

}