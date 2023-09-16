package LogicCode.Appointment;

import Database.BusAppointmentTable;

public class AppointmentManagerModel {
    BusAppointmentTable BAT= new BusAppointmentTable();
    public void createAppointment(AppointmentModel a){
        BAT.insert(a);
    }

    public void UpdateAppointmentDate(int id, String date){
        BAT.updateDate(id, date);
    }

    public void UpdateAppointmentDestination(int id, String dest){
        BAT.updateDestination(id, dest);
    }

    public void DeleteAppointment(int id){
        BAT.delete(id);
    }
}
