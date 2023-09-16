package LogicCode.Traveller;

import Database.Notifications;
import LogicCode.Notifications.NotificationController;
import LogicCode.Notifications.NotificationModel;

public class TravellerController implements observer{
    private TravellerModel Model=new TravellerModel();
    private TravellerAppointmentOptions TAO=new TravellerAppointmentOptions();
    private TravellerRequestOptions TRO=new TravellerRequestOptions();
    private NotificationController NC=new NotificationController();

    public NotificationController getNC() {
        return NC;
    }

    public void setNC(NotificationController NC) {
        this.NC = NC;
    }

    public String GetTravellerData() {
        return this.Model.GetTravellerData();
    }



    public TravellerModel getModel() {
        return Model;
    }

    public void setModel(TravellerModel model) {
        this.Model = model;
    }

    public TravellerAppointmentOptions getTAO() {
        return TAO;
    }

    public void setTAO(TravellerAppointmentOptions TAO) {
        this.TAO = TAO;
    }

    public TravellerRequestOptions getTRO() {
        return TRO;
    }

    public void setTRO(TravellerRequestOptions TRO) {
        this.TRO = TRO;
    }

    @Override
    public void UpdateWithNewAppointment(String News,int AppID,int TID) {
        System.out.println(News+AppID+TID);
        NotificationModel nm = new NotificationModel(TID,AppID,News);
        nm.SaveNotification(nm);
    }
}
