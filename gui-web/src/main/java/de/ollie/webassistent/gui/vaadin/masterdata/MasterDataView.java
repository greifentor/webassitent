package de.ollie.webassistent.gui.vaadin.masterdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

import de.ollie.webassistent.core.service.localization.ResourceManager;
import de.ollie.webassistent.gui.SessionData;
import de.ollie.webassistent.gui.vaadin.MainMenuView;
import de.ollie.webassistent.gui.vaadin.UserAuthorizationChecker;
import de.ollie.webassistent.gui.vaadin.component.Button;
import de.ollie.webassistent.gui.vaadin.component.ButtonFactory;
import de.ollie.webassistent.gui.vaadin.component.ButtonGrid;
import de.ollie.webassistent.gui.vaadin.component.HeaderLayout;
import de.ollie.webassistent.gui.vaadin.component.HeaderLayout.HeaderLayoutMode;
import de.ollie.webassistent.gui.vaadin.component.MasterDataViewButtonAdder;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * A layout with buttons to select a master data page.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Route(MasterDataView.URL)
@RequiredArgsConstructor
public class MasterDataView extends Scroller implements BeforeEnterObserver, HasUrlParameter<String> {

	public static final String URL = "webassistent/masterdata/menu";

	private static final Logger LOG = LogManager.getLogger(MasterDataView.class);

	private final ButtonFactory buttonFactory;
	private final MasterDataGUIConfiguration guiConfiguration;
	private final ResourceManager resourceManager;
	private final SessionData session;

	@Autowired(required = false)
	private MasterDataViewButtonAdder masterDataViewButtonAdder;

	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
		LOG.debug("setParameter");
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		UserAuthorizationChecker.forwardToLoginOnNoUserSetForSession(session, beforeEnterEvent);
		LOG.info("created");
		setSizeFull();
		getStyle().set("background-image", "url('" + guiConfiguration.getBackgroundFileName() + "')");
		getStyle().set("background-size", "cover");
		getStyle().set("background-attachment", "fixed");
		Button buttonMasterDataAppointment =
				buttonFactory
						.createButton(
								resourceManager
										.getLocalizedString(
												"master-data.button.appointment.text",
												session.getLocalization()));
		buttonMasterDataAppointment.addClickListener(event -> switchToSourceAppointment());
		buttonMasterDataAppointment.setWidthFull();
		Button buttonMasterDataNote =
				buttonFactory
						.createButton(
								resourceManager
										.getLocalizedString(
												"master-data.button.note.text",
												session.getLocalization()));
		buttonMasterDataNote.addClickListener(event -> switchToSourceNote());
		buttonMasterDataNote.setWidthFull();
		List<Button> buttons =
				new ArrayList<>(
						Arrays
								.asList(
										buttonMasterDataAppointment,
										buttonMasterDataNote
								));
		if (masterDataViewButtonAdder != null) {
			buttons.addAll(masterDataViewButtonAdder.createButtonsToAdd(session, () -> getUI()));
		} 
		ButtonGrid buttonGrid = new ButtonGrid(4, buttons);
		buttonGrid.setMargin(false);
		buttonGrid.setWidthFull();
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
		mainLayout.setMargin(false);
		mainLayout
				.add(
						new HeaderLayout(
								buttonFactory.createBackButton(resourceManager, this::getUI, MainMenuView.URL, session),
								buttonFactory.createLogoutButton(resourceManager, this::getUI, session, LOG),
								resourceManager.getLocalizedString("master-data.header.menu.label", session.getLocalization()),
								HeaderLayoutMode.PLAIN),
						buttonGrid);
		setContent(mainLayout);
		LOG.info("main menu view opened for user '{}'.", session.getUserName());
	}

	private void switchToSourceAppointment() {
		getUI().ifPresent(ui -> ui.navigate(AppointmentPageView.URL));
	}

	private void switchToSourceNote() {
		getUI().ifPresent(ui -> ui.navigate(NotePageView.URL));
	}

}