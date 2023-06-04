package de.ollie.webassistent.gui.vaadin.masterdata;

import javax.inject.Named;

import de.ollie.webassistent.core.model.Note;

@Named
public class NotePageViewMasterDataGridFieldRenderer implements MasterDataGridFieldRenderer<Note> {

	@Override
	public Object getHeaderString(String fieldName, Note t) {
		if (Note.USER.equals(fieldName) && t.getUser() != null) {
			return t.getUser().getName();
		}
		return null;
	}

	@Override
	public boolean hasRenderingFor(String fieldName) {
		return Note.USER.equals(fieldName);
	}

}
