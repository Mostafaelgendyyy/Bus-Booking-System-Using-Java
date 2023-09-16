package LogicCode.Admin;

import LogicCode.Appointment.AppointmentController;
import LogicCode.Appointment.AppointmentModel;
import LogicCode.Request.RequestController;
import LogicCode.Traveller.TravellerController;
import LogicCode.Traveller.TravellerModel;

import java.security.PrivateKey;
import java.util.ArrayList;

public class AdminAppointmentOptions {
    private AppointmentController AC=new AppointmentController();


    public void createAppointment(AppointmentModel a){
        this.AC.createAppointment(a);
    }


    public void UpdateAppointmentDate(int id, String date){
        this.AC.UpdateAppointmentDate(id, date);
        //ArrayList<TravellerModel> T= RC.getModel().sendResponseRequest()
    }

    public void UpdateAppointmentDestination(int id, String dest){
        this.AC.UpdateAppointmentDestination(id, dest);
    }

    public void DeleteAppointment(int id){
        this.AC.DeleteAppointment(id);
    }
}
