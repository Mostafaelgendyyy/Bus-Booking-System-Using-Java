package LogicCode.Notifications;

import Database.Notifications;

public class NotificationModel {
    private int noticicationID;
    private int travellerID;
    private int AppointmentID;
    private String Description;
    private Notifications NT;

    public NotificationModel()
    {

    }
    public Notifications getNT() {
        return NT;
    }

    public void setNT(Notifications NT) {
        this.NT = NT;
    }

    public NotificationModel(int noticicationID, int travellerID, int appointmentID, String description) {
        this.noticicationID = noticicationID;
        this.travellerID = travellerID;
        AppointmentID = appointmentID;
        Description = description;
    }

    public NotificationModel(int travellerID, int appointmentID, String description) {
        this.travellerID = travellerID;
        AppointmentID = appointmentID;
        Description = description;
    }

    public int getNoticicationID() {
        return noticicationID;
    }

    public void setNoticicationID(int noticicationID) {
        this.noticicationID = noticicationID;
    }

    public int getTravellerID() {
        return travellerID;
    }

    public void setTravellerID(int travellerID) {
        this.travellerID = travellerID;
    }

    public int getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        AppointmentID = appointmentID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void SaveNotification(NotificationModel nm)
    {
        NT.insert(nm);
    }
    public void DeleteNotification(NotificationModel nm)
    {
        NT.delete(nm);
    }
    public String GetNotificationData() {
        return "NotificationModel{" +
                "noticicationID=" + noticicationID +
                ", travellerID=" + travellerID +
                ", AppointmentID=" + AppointmentID +
                ", Description='" + Description + '\'' +
                '}';
    }
}
