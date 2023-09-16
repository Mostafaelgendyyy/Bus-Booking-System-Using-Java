package LogicCode.Appointment;

import java.util.Date;

public class AppointmentModel {
    private int AppointmentId;
    private String Destination;
    private String date;
    private int maxTravellers;
    private float price ;
    private int Requests;

    private AppointmentManagerModel Manager= new AppointmentManagerModel();
    private AppointmentSearcherModel Searcher= new AppointmentSearcherModel();

    public AppointmentModel() {
    }

    public AppointmentModel(int appointmentId, String destination, String date, int maxTravellers,int numReq) {
        this.AppointmentId = appointmentId;
        this.Destination = destination;
        this.date = date;
        this.maxTravellers = maxTravellers;
        this.Requests=numReq;
    }

    public AppointmentModel(String destination, String date, int maxTravellers,int numReq) {
        this.Destination = destination;
        this.date = date;
        this.maxTravellers = maxTravellers;
        this.Requests=numReq;
    }

    public int getRequests() {
        return Requests;
    }

    public void setRequests(int requests) {
        Requests = requests;
    }

    public String getAppointmentData() {
        return "AppointmentModel{" +
                "AppointmentId=" + AppointmentId +
                ", Destination='" + Destination + '\'' +
                ", date=" + date +
                ", maxTravellers=" + maxTravellers +
                ", price=" + price +
                ", Requests=" + Requests +
                '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAppointmentId() {
        return AppointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        AppointmentId = appointmentId;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AppointmentManagerModel getManager() {
        return Manager;
    }

    public void setManager(AppointmentManagerModel manager) {
        Manager = manager;
    }

    public AppointmentSearcherModel getSearcher() {
        return Searcher;
    }

    public void setSearcher(AppointmentSearcherModel searcher) {
        Searcher = searcher;
    }

    public int getMaxTravellers() {
        return maxTravellers;
    }

    public void setMaxTravellers(int maxTravellers) {
        this.maxTravellers = maxTravellers;
    }
}
