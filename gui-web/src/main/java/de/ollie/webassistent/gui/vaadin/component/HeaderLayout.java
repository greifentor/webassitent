package de.ollie.webassistent.gui.vaadin.component;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import lombok.Generated;

/**
 * A layout for the page headers.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@Generated
public class HeaderLayout extends HorizontalLayout {

	public enum HeaderLayoutMode {
		PLAIN,
		WRAPPED;
	}

	public HeaderLayout(Button buttonLogout, String labelText, HeaderLayoutMode mode) {
		this(null, buttonLogout, labelText, mode);
	}

	public HeaderLayout(Button buttonBack, Button buttonLogout, String labelText, HeaderLayoutMode mode) {
		if (mode == HeaderLayoutMode.WRAPPED) {
			HorizontalLayout wrapper = new HorizontalLayout();
			prepareLayout(wrapper);
			wrapper.add(getInnerLayout(buttonBack, buttonLogout, labelText));
			setWidthFull();
			setPadding(true);
			add(wrapper);
		} else {
			prepareLayout(this);
			add(getInnerLayout(buttonBack, buttonLogout, labelText));
		}
	}

	private void prepareLayout(HorizontalLayout layout) {
		layout.setWidthFull();
		layout.setPadding(true);
		layout.getStyle().set("-moz-border-radius", "4px");
		layout.getStyle().set("-webkit-border-radius", "4px");
		layout.getStyle().set("border-radius", "4px");
		layout.getStyle().set("border", "1px solid gray");
		layout
				.getStyle()
				.set(
						"box-shadow",
						"10px 10px 20px #e4e4e4, -10px 10px 20px #e4e4e4, -10px -10px 20px #e4e4e4, 10px -10px 20px #e4e4e4");
	}

	private HorizontalLayout getInnerLayout(Button buttonBack, Button buttonLogout, String labelText) {
		HorizontalLayout headerInner = new HorizontalLayout();
		headerInner.setWidthFull();
		headerInner.setMargin(false);
		Label label = new Label(labelText);
		label.setWidthFull();
		label.getStyle().set("display", "flex");
		label.getStyle().set("align-items", "center");
		label.getStyle().set("font-weight", "bold");
		buttonLogout.setWidth("15%");
		if (buttonBack == null) {
			headerInner.add(label, buttonLogout);
		} else {
			buttonBack.setWidth("15%");
			headerInner.add(label, buttonLogout, buttonBack);
		}
		return headerInner;
	}
}