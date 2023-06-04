package de.ollie.webassistent.core.model;

import lombok.Data;
import lombok.Generated;
import lombok.experimental.Accessors;

/**
 * A model for notes.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Accessors(chain = true)
@Data
@Generated
public class GeneratedNote {

	public static final String ID = "ID";
	public static final String USER = "USER";
	public static final String CONTENT = "CONTENT";
	public static final String TITLE = "TITLE";

	private long id;
	private User user;
	private String content;
	private String title;

}