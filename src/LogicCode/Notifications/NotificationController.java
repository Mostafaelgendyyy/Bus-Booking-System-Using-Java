package LogicCode.Notifications;

public class NotificationController {
    NotificationModel Model= new NotificationModel();

    public String GetNotificationData(){
        return Model.GetNotificationData();
    }

    public NotificationModel getModel() {
        return Model;
    }

    public void setModel(NotificationModel model) {
        Model = model;
    }
}
