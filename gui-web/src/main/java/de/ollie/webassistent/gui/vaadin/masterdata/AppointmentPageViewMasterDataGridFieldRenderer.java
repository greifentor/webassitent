package de.ollie.webassistent.gui.vaadin.masterdata;

import javax.inject.Named;

import de.ollie.webassistent.core.model.Appointment;
import de.ollie.webassistent.gui.utils.DateUtils;

@Named
public class AppointmentPageViewMasterDataGridFieldRenderer implements MasterDataGridFieldRenderer<Appointment> {

	@Override
	public Object getHeaderString(String fieldName, Appointment t) {
		if (Appointment.USER.equals(fieldName) && t.getUser() != null) {
			return t.getUser().getName();
		} else if (Appointment.TIMEEND.equals(fieldName)) {
			return DateUtils.formatLocalDateTime(t.getTimeEnd());
		} else if (Appointment.TIMESTART.equals(fieldName)) {
			return DateUtils.formatLocalDateTime(t.getTimeStart());
		}
		return null;
	}

	@Override
	public boolean hasRenderingFor(String fieldName) {
		return Appointment.USER.equals(fieldName) || Appointment.TIMEEND.equals(fieldName)
				|| Appointment.TIMESTART.equals(fieldName);
	}

}
