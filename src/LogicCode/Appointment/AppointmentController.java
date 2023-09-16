package LogicCode.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentController {
    private AppointmentModel Model= new AppointmentModel();

    public ArrayList<AppointmentModel> searchAppointmentsbyDate(String d) throws SQLException {
        ArrayList<AppointmentModel> m=this.Model.getSearcher().searchAppointmentsbyDate(d);
        return m;
    }

    public ArrayList<AppointmentModel> searchAppointmentsbyDestination(String d) throws SQLException {
        ArrayList<AppointmentModel> m=this.Model.getSearcher().searchAppointmentsbyDestination(d);
        return m;

    }
    public ArrayList<AppointmentModel> getUnCompletedAppointments() throws SQLException {// With no Acceptance
        ArrayList<AppointmentModel> m=this.Model.getSearcher().getUnCompletedAppointments();
        return m;
    }

    public void createAppointment(AppointmentModel a){
        this.Model.getManager().createAppointment(a);
    }

    public void UpdateAppointmentDate(int id, String date){
        this.Model.getManager().UpdateAppointmentDate(id, date);
    }

    public void UpdateAppointmentDestination(int id, String dest){
        this.Model.getManager().UpdateAppointmentDestination(id, dest);
    }

    public void DeleteAppointment(int id){
        this.Model.getManager().DeleteAppointment(id);
    }

    public String getAppointmentData() {
        return this.Model.getAppointmentData();
    }

    public AppointmentModel getModel() {
        return Model;
    }

    public void setModel(AppointmentModel model) {
        Model = model;
    }
}
