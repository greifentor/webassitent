package de.ollie.webassistent.gui.vaadin.masterdata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

import de.ollie.webassistent.core.model.Note;
import de.ollie.webassistent.core.service.NoteService;
import de.ollie.webassistent.core.service.UserService;
import de.ollie.webassistent.core.service.localization.ResourceManager;
import de.ollie.webassistent.gui.SessionData;
import de.ollie.webassistent.gui.vaadin.UserAuthorizationChecker;
import de.ollie.webassistent.gui.vaadin.component.AbstractMasterDataBaseLayout;
import de.ollie.webassistent.gui.vaadin.component.ButtonFactory;
import de.ollie.webassistent.gui.vaadin.component.HeaderLayout;
import de.ollie.webassistent.gui.vaadin.component.HeaderLayout.HeaderLayoutMode;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * A dialog to edit Note details.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
@Route(NoteMaintenanceView.URL)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@CssImport(value = "./styles/vaadin-text-area-styles.css", themeFor = "vaadin-text-area")
@CssImport(value = "./styles/vaadin-combo-box-styles.css", themeFor = "vaadin-combo-box")
@CssImport(value = "./styles/vaadin-checkbox-styles.css", themeFor = "vaadin-checkbox")
@RequiredArgsConstructor
public class NoteMaintenanceView extends AbstractMasterDataBaseLayout implements NoteDetailsLayout.Observer {

	public static final String URL = "webassistent/masterdata/notes/details";

	private static final Logger logger = LogManager.getLogger(NoteMaintenanceView.class);

	@Autowired(required = false)
	private MaintenanceViewRenderer<Note> maintenanceViewRenderer;
	@Autowired(required = false)
	private DetailsLayoutComboBoxItemLabelGenerator<Note> comboBoxItemLabelGenerator;

	private final ButtonFactory buttonFactory;
	private final ResourceManager resourceManager;
	private final MasterDataGUIConfiguration guiConfiguration;
	private final NoteService service;
	private final UserService userService;
	private final SessionData session;

	private Note model;

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
	public void doSetParameter(BeforeEvent event) {
		long id = parametersMap.containsKey("id") && (parametersMap.get("id").size() > 0)
				? Long.parseLong(parametersMap.get("id").get(0))
				: -1;
		model = service.findById(id).orElse(createNewModel());
		if (parametersMap.containsKey("duplicate") && "true".equals(parametersMap.get("duplicate").get(0))) {
			model.setId(-1);
		}
	}

	private Note createNewModel() {
		return new Note();
	}

	@Override
	public void doBeforeEnter(BeforeEnterEvent beforeEnterEvent) {
		UserAuthorizationChecker.forwardToLoginOnNoUserSetForSession(getSessionData(), beforeEnterEvent);
		setMargin(false);
		setSizeFull();
		getStyle().set("background-image", "url('" + guiConfiguration.getBackgroundFileName() + "')");
		getStyle().set("background-size", "cover");
		getStyle().set("background-attachment", "fixed");
		add(
				new HeaderLayout(
						buttonFactory
										.createBackButton(
												resourceManager,
												this::getUI,
												NotePageView.URL,
												session),
						buttonFactory.createLogoutButton(resourceManager, this::getUI, session, logger),
								resourceManager.getLocalizedString("NoteMaintenanceView.header.prefix.label", session.getLocalization()) + getHeaderSuffix(model),
								HeaderLayoutMode.PLAIN),
				getDetailsLayout(model));
	}

	private String getHeaderSuffix(Note model) {
		return maintenanceViewRenderer != null
				? maintenanceViewRenderer.getHeaderSuffix(model)
				: "" + model.getTitle();
	}

	private AbstractMasterDataBaseLayout getDetailsLayout(Note model) {
		return new NoteDetailsLayout(buttonFactory, model, service, userService, resourceManager, session, this, comboBoxItemLabelGenerator);
	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		logger.info("onAttach");
		super.onAttach(attachEvent);
	}

	@Override
	protected void onDetach(DetachEvent detachEvent) {
		logger.info("onDetach");
		super.onDetach(detachEvent);
		getElement().removeFromTree();
	}

	@Override
	public void save(Object model) {
		getUI().ifPresent(ui -> ui.navigate(NotePageView.URL));
	}

	@Override
	public void save() {
		save(model);
	}

	@Override
	public void remove() {
		service.delete(model);
		getUI().ifPresent(ui -> ui.navigate(NotePageView.URL));
	}

}