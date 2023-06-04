package de.ollie.webassistent.gui.vaadin.component;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.vaadin.flow.component.UI;

import de.ollie.webassistent.gui.SessionData;
import lombok.Generated;

/**
 * Can be implemented to add buttons to the master data view.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public interface MasterDataViewButtonAdder {

	List<Button> createButtonsToAdd(SessionData session, Supplier<Optional<UI>> uiSupplier);

}