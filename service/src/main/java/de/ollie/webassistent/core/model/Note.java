package de.ollie.webassistent.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * A model for notes.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Generated
@ToString(callSuper = true)
public class Note extends GeneratedNote {

	@Override
	public Note setId(long id) {
		super.setId(id);
		return this;
	}

	@Override
	public Note setUser(User user) {
		super.setUser(user);
		return this;
	}

	@Override
	public Note setContent(String content) {
		super.setContent(content);
		return this;
	}

	@Override
	public Note setTitle(String title) {
		super.setTitle(title);
		return this;
	}

}