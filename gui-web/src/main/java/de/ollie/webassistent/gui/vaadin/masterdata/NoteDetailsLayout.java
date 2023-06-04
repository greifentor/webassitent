package de.ollie.webassistent.gui.vaadin.masterdata;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;

import de.ollie.webassistent.core.model.Note;
import de.ollie.webassistent.core.model.User;
import de.ollie.webassistent.core.service.localization.ResourceManager;
import de.ollie.webassistent.core.service.NoteService;
import de.ollie.webassistent.core.service.UserService;
import de.ollie.webassistent.gui.SessionData;
import de.ollie.webassistent.gui.vaadin.component.AbstractMasterDataBaseLayout;
import de.ollie.webassistent.gui.vaadin.component.ButtonFactory;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@RequiredArgsConstructor
public class NoteDetailsLayout extends AbstractMasterDataBaseLayout {

	private final ButtonFactory buttonFactory;
	private final Note model;
	private final NoteService service;
	private final UserService userService;
	private final ResourceManager resourceManager;
	private final SessionData session;
	private final Observer observer;
	private final DetailsLayoutComboBoxItemLabelGenerator<Note> comboBoxItemLabelGenerator;

	private ComboBox<User> comboBoxUser;
	private TextField textFieldTitle;
	private TextField textFieldContent;

	@Override
	public void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		createButtons();
		comboBoxUser = createComboBox("NoteDetailsLayout.field.user.label", model.getUser(), userService.findAll().toArray(new User[0]));
		comboBoxUser
				.setItemLabelGenerator(
						user  -> comboBoxItemLabelGenerator != null
								? comboBoxItemLabelGenerator.getLabel(Note.USER, user)
								: "" + user.getName());
		textFieldTitle = createTextField("NoteDetailsLayout.field.title.label", model.getTitle());
		textFieldContent = createTextField("NoteDetailsLayout.field.content.label", model.getContent());
		getStyle().set("-moz-border-radius", "4px");
		getStyle().set("-webkit-border-radius", "4px");
		getStyle().set("border-radius", "4px");
		getStyle().set("border", "1px solid #A9A9A9");
		getStyle()
				.set(
						"box-shadow",
						"10px 10px 20px #e4e4e4, -10px 10px 20px #e4e4e4, -10px -10px 20px #e4e4e4, 10px -10px 20px #e4e4e4");
		setMargin(false);
		setWidthFull();
		add(
				textFieldTitle,
				comboBoxUser,
				textFieldContent,
				getMasterDataButtonLayout(model.getId() > 0));
		textFieldTitle.focus();
	}

	@Override
	protected ButtonFactory getButtonFactory() {
		return buttonFactory;
	}

	@Override
	protected ResourceManager getResourceManager() {
		return resourceManager;
	}

	@Override
	protected SessionData getSessionData() {
		return session;
	}

	@Override
	protected void remove() {
		service.delete(model);
		observer.remove();
	}

	@Override
	protected void save() {
		model.setTitle(textFieldTitle.getValue());
		model.setUser(comboBoxUser.getValue());
		model.setContent(textFieldContent.getValue());
		observer.save(service.update(model));
	}

}