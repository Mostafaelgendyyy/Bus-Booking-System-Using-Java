package LogicCode.Appointment;

import Database.BusAppointmentTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentSearcherModel {
    BusAppointmentTable BAT= new BusAppointmentTable();
    public ArrayList<AppointmentModel> searchAppointmentsbyDate(String d) throws SQLException {
        ArrayList<AppointmentModel> result =BAT.getAppointmentsbyDate(d);
        return result;
    }

    public ArrayList<AppointmentModel> searchAppointmentsbyDestination(String d) throws SQLException {
        ArrayList<AppointmentModel> result =BAT.getAppointmentsbyDestination(d);
        return result;

    }
    public ArrayList<AppointmentModel> getUnCompletedAppointments() throws SQLException {
        ArrayList<AppointmentModel> result =BAT.getUnCompletedAppointments();
        return result;
    }

    public ArrayList<AppointmentModel> getAllAppointments() throws SQLException {
        ArrayList<AppointmentModel> result =BAT.getAllAppointments();
        return result;
    }
}
