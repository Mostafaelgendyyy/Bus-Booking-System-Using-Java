package LogicCode.Request;

import java.sql.SQLException;

public class RequestModel {
    private int id;
    private boolean paid;
    private int TravellerId;
    private int AdminID;
    private int appointmentID;
    private boolean Acceptance;
    private int Requests;
    private RequestLoggerModel logger= new RequestLoggerModel();
    private RequestManagerModel Manager= new RequestManagerModel();
    private RequestUnConfirmed RUC= new RequestUnConfirmed();


    public RequestModel() {

    }
    public RequestModel(int id, boolean paid, int travellerId, int adminID, int appointmentID, boolean acceptance ) {
        this.id = id;
        this.paid = paid;
        this.TravellerId = travellerId;
        this.AdminID = adminID;
        this.appointmentID = appointmentID;
        this.Acceptance = acceptance;
    }
    public RequestModel(boolean paid, int travellerId, int appointmentID, boolean acceptance ) {
        this.paid = paid;
        this.TravellerId = travellerId;
        this.appointmentID = appointmentID;
        this.Acceptance = acceptance;
    }

    public boolean sendResponseRequest(){
        return this.Acceptance;
    }


    public String getRequestData() {
        return "RequestModel{" +
                "id=" + id +
                ", paid=" + paid +
                ", TravellerId=" + TravellerId +
                ", AdminID=" + AdminID +
                ", appointmentID=" + appointmentID +
                ", Acceptance=" + Acceptance +
                '}';
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getTravellerId() {
        return TravellerId;
    }

    public void setTravellerId(int travellerId) {
        TravellerId = travellerId;
    }

    public boolean isAcceptance() {
        return Acceptance;
    }

    public void setAcceptance(boolean acceptance) {
        Acceptance = acceptance;
    }

    public RequestLoggerModel getLogger() {
        return logger;
    }

    public void setLogger(RequestLoggerModel logger) {
        this.logger = logger;
    }

    public RequestManagerModel getManager() {
        return Manager;
    }

    public void setManager(RequestManagerModel manager) {
        Manager = manager;
    }



    public RequestUnConfirmed getRUC() {
        return RUC;
    }

    public void setRUC(RequestUnConfirmed RUC) {
        this.RUC = RUC;
    }



}
