package LogicCode.Traveller;

import LogicCode.Appointment.AppointmentController;
import LogicCode.Appointment.AppointmentModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TravellerAppointmentOptions {
    private AppointmentController AC= new AppointmentController();

    public ArrayList<AppointmentModel> searchAppointmentsbyDate(String d) throws SQLException {
        return AC.searchAppointmentsbyDate(d);
    }

    public ArrayList<AppointmentModel> searchAppointmentsbyDestination(String d) throws SQLException {
        return AC.searchAppointmentsbyDestination(d);
    }
    public ArrayList<AppointmentModel> getUnCompletedAppointments() throws SQLException {// With no Acceptance
        return AC.getUnCompletedAppointments();
    }

    public AppointmentController getAC() {
        return AC;
    }

    public void setAC(AppointmentController AC) {
        this.AC = AC;
    }
}
