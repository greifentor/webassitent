package de.ollie.webassistent.gui.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtils {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm");

	public String formatLocalDateTime(LocalDateTime localDateTime) {
		return localDateTime != null ? localDateTime.format(formatter) : "-";
	}

}
