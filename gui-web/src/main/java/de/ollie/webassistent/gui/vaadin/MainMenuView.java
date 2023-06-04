package de.ollie.webassistent.gui.vaadin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import de.ollie.webassistent.gui.vaadin.component.Button;
import de.ollie.webassistent.gui.vaadin.component.ButtonFactory;
import de.ollie.webassistent.gui.vaadin.component.ButtonGrid;
import de.ollie.webassistent.gui.vaadin.component.HeaderLayout;
import de.ollie.webassistent.gui.vaadin.component.HeaderLayout.HeaderLayoutMode;
import de.ollie.webassistent.gui.vaadin.GUIConfiguration;
import de.ollie.webassistent.gui.vaadin.UserAuthorizationChecker;
import de.ollie.webassistent.gui.vaadin.masterdata.MasterDataView;

import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * A main menu view for the application.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Route(MainMenuView.URL)
@RequiredArgsConstructor
public class MainMenuView extends Scroller implements BeforeEnterObserver, HasUrlParameter<String> {

	public static final String URL = "webassistent/menu";

	private static final Logger LOG = LogManager.getLogger(MainMenuView.class);

	private final ButtonFactory buttonFactory;
	private final GUIConfiguration guiConfiguration;
	private final ResourceManager resourceManager;
	private final SessionData session;

	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
		LOG.debug("setParameter");
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		UserAuthorizationChecker.forwardToLoginOnNoUserSetForSession(session, beforeEnterEvent);
		LOG.info("created");
		setWidthFull();
		getStyle().set("background-image", "url('" + guiConfiguration.getMainMenuBackgroundFileName() + "')");
		getStyle().set("background-size", "cover");
		getStyle().set("background-attachment", "fixed");
		Button buttonMasterData =
				buttonFactory
						.createButton(
								resourceManager
										.getLocalizedString(
												"main-menu.button.master-data.text",
												session.getLocalization()));
		buttonMasterData.addClickListener(event -> switchToMasterData());
		buttonMasterData.setWidthFull();
		ButtonGrid buttonGridMasterData = new ButtonGrid(4, buttonMasterData);
		buttonGridMasterData.setMargin(false);
		buttonGridMasterData.setWidthFull();
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.add(
				new HeaderLayout(
						buttonFactory.createLogoutButton(resourceManager, this::getUI, session, LOG),
						resourceManager.getLocalizedString("commons.header.main-menu.label", session.getLocalization()),
						HeaderLayoutMode.PLAIN),
				buttonGridMasterData);
		setContent(mainLayout);
		LOG.info("main menu view opened for user '{}'.", session.getUserName());
	}

	private void switchToMasterData() {
		getUI().ifPresent(ui -> ui.navigate(MasterDataView.URL));
	}

}
