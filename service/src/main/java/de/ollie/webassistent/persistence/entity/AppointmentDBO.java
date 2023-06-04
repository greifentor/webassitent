package de.ollie.webassistent.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Generated;
import lombok.experimental.Accessors;

/**
 * A DBO for appointments.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Accessors(chain = true)
@Data
@Generated
@Entity(name = "Appointment")
@Table(name = "APPOINTMENT")
public class AppointmentDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private long id;
	@JoinColumn(name = "USER", nullable = false, referencedColumnName = "ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private UserDBO user;
	@Column(name = "TIME_END")
	private LocalDateTime timeEnd;
	@Column(name = "TIME_START", nullable = false)
	private LocalDateTime timeStart;
	@Column(name = "TITLE", nullable = false)
	private String title;

}