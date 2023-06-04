package de.ollie.webassistent.persistence.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import lombok.Generated;
import lombok.RequiredArgsConstructor;

import de.ollie.webassistent.persistence.entity.NoteDBO;
import de.ollie.webassistent.core.model.Note;

/**
 * A DBO converter for notes.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Named
@RequiredArgsConstructor
public class NoteDBOConverter implements ToModelConverter<Note, NoteDBO> {

	private final UserDBOConverter userDBOConverter;

	public NoteDBO toDBO(Note model) {
		if (model == null) {
			return null;
		}
		return new NoteDBO()
				.setId(model.getId())
				.setUser(userDBOConverter.toDBO(model.getUser()))
				.setContent(model.getContent())
				.setTitle(model.getTitle());
	}

	@Override
	public Note toModel(NoteDBO dbo) {
		if (dbo == null) {
			return null;
		}
		return new Note()
				.setId(dbo.getId())
				.setUser(userDBOConverter.toModel(dbo.getUser()))
				.setContent(dbo.getContent())
				.setTitle(dbo.getTitle());
	}

	@Override
	public List<Note> toModel(List<NoteDBO> dbos) {
		if (dbos == null) {
			return null;
		}
		return dbos.stream().map(this::toModel).collect(Collectors.toList());
	}

}