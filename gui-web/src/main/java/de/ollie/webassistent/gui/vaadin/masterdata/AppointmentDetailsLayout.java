package de.ollie.webassistent.gui.vaadin.masterdata;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.textfield.TextField;

import de.ollie.webassistent.core.model.Appointment;
import de.ollie.webassistent.core.model.User;
import de.ollie.webassistent.core.service.AppointmentService;
import de.ollie.webassistent.core.service.localization.ResourceManager;
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
public class AppointmentDetailsLayout extends AbstractMasterDataBaseLayout {

	private final ButtonFactory buttonFactory;
	private final Appointment model;
	private final AppointmentService service;
	private final UserService userService;
	private final ResourceManager resourceManager;
	private final SessionData session;
	private final Observer observer;
	private final DetailsLayoutComboBoxItemLabelGenerator<Appointment> comboBoxItemLabelGenerator;

	private ComboBox<User> comboBoxUser;
	private TextField textFieldTitle;
	private DateTimePicker dateTimePickerTimeStart;
	private DateTimePicker dateTimePickerTimeEnd;

	@Override
	public void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		createButtons();
		comboBoxUser = createComboBox("AppointmentDetailsLayout.field.user.label", model.getUser(), userService.findAll().toArray(new User[0]));
		comboBoxUser
				.setItemLabelGenerator(
						user  -> comboBoxItemLabelGenerator != null
								? comboBoxItemLabelGenerator.getLabel(Appointment.USER, user)
								: "" + user.getName());
		textFieldTitle = createTextField("AppointmentDetailsLayout.field.title.label", model.getTitle());
		dateTimePickerTimeStart = new DateTimePicker(resourceManager.getLocalizedString("AppointmentDetailsLayout.field.timestart.label", session.getLocalization()), model.getTimeStart(), event -> {});
		dateTimePickerTimeEnd = new DateTimePicker(resourceManager.getLocalizedString("AppointmentDetailsLayout.field.timeend.label", session.getLocalization()), model.getTimeEnd(), event -> {});
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
				dateTimePickerTimeStart,
				dateTimePickerTimeEnd,
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
		model.setTimeStart(dateTimePickerTimeStart.getValue());
		model.setTimeEnd(dateTimePickerTimeEnd.getValue());
		observer.save(service.update(model));
	}

}