package LogicCode.Admin;

import LogicCode.Traveller.TravellerController;
import LogicCode.Traveller.TravellerModel;
import LogicCode.Traveller.observer;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminController implements Notifier{
    private AdminModel Model= new AdminModel();
    private AdminRequestsOption ARO=new AdminRequestsOption();
    private AdminAppointmentOptions AAO= new AdminAppointmentOptions();


    public String getAdminData() {
       return this.Model.getAdminData();
    }

    public AdminModel getModel() {
        return this.Model;
    }

    public void setModel(AdminModel model) {
        Model = model;
    }

    public AdminRequestsOption getARO() {
        return ARO;
    }

    public void setARO(AdminRequestsOption ARO) {
        this.ARO = ARO;
    }

    public AdminAppointmentOptions getAAO() {
        return AAO;
    }

    public void setAAO(AdminAppointmentOptions AAO) {
        this.AAO = AAO;
    }

    @Override
    public void NotifiyTraveller(observer o,String News,int AppID,int TID) {
        o.UpdateWithNewAppointment(News,AppID,TID);
    }


    public void UpdateAppointmentDate(int id, String date) throws SQLException {
        this.AAO.UpdateAppointmentDate(id, date);
        ArrayList<Integer> Trav=this.ARO.getRC().getModel().getManager().TravellersNotified(id);
        String News="This Notification About Appointment " +id+ "Its Date has CHanged to "+date;
        for (int i=0;i<Trav.size();++i)
        {
            TravellerController TC= new TravellerController();
            this.NotifiyTraveller(TC,News,id,Trav.get(i));
        }

    }

    public void UpdateAppointmentDestination(int id, String dest) throws SQLException {
        this.AAO.UpdateAppointmentDestination(id, dest);
        ArrayList<Integer> Trav=this.ARO.getRC().getModel().getManager().TravellersNotified(id);
        String News="This Notification About Appointment " +id+ "Its Date has CHanged to "+dest;
        for (int i=0;i<Trav.size();++i)
        {
            TravellerController TC= new TravellerController();
            this.NotifiyTraveller((observer)TC,News,id,Trav.get(i));
        }

    }

}
