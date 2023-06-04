package de.ollie.webassistent.persistence.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import lombok.Generated;

import de.ollie.webassistent.persistence.entity.UserDBO;
import de.ollie.webassistent.core.model.User;

/**
 * A DBO converter for users.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Named
public class UserDBOConverter implements ToModelConverter<User, UserDBO> {

	public UserDBO toDBO(User model) {
		if (model == null) {
			return null;
		}
		return new UserDBO()
				.setId(model.getId())
				.setCurrentSitzung(model.getCurrentSitzung())
				.setGlobalId(model.getGlobalId())
				.setName(model.getName())
				.setToken(model.getToken());
	}

	@Override
	public User toModel(UserDBO dbo) {
		if (dbo == null) {
			return null;
		}
		return new User()
				.setId(dbo.getId())
				.setCurrentSitzung(dbo.getCurrentSitzung())
				.setGlobalId(dbo.getGlobalId())
				.setName(dbo.getName())
				.setToken(dbo.getToken());
	}

	@Override
	public List<User> toModel(List<UserDBO> dbos) {
		if (dbos == null) {
			return null;
		}
		return dbos.stream().map(this::toModel).collect(Collectors.toList());
	}

}