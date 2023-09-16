package Database;

import LogicCode.Notifications.NotificationModel;
import LogicCode.Request.RequestModel;

import java.sql.*;
import java.util.ArrayList;

import static Database.Connector.*;

public class Notifications {
    Connector executer = new Connector();

    public void createTable(){
        String sql = "CREATE TABLE Notification " +
                "(notificationId INTEGER AUTO_INCREMENT, " +
                " travellerId INTEGER, " +
                " appointmentId INTEGER, " +
                " description VARCHAR(200), " +
                " PRIMARY KEY ( notificationId )," +
                " FOREIGN KEY (travellerId) REFERENCES Traveller(travellerId)," +
                " FOREIGN KEY (appointmentId) REFERENCES BusAppointment(appointmentId))";
        executer.ExecuteQuery(sql);
    }

    public void insert(NotificationModel nm)
    {
        String sql ="INSERT INTO Notification(travellerId,appointmentId,description) VALUES" +
                " ("+nm.getTravellerID()+", "+nm.getAppointmentID() +", '"+nm.getDescription()+"')";
        executer.ExecuteQuery(sql);
    }


    public void delete(NotificationModel nm)
    {
        String sql ="DELETE FROM Notification WHERE notificationId="+nm.getNoticicationID() ;
        executer.ExecuteQuery(sql);
    }

    public void FreeTravellerNotification(NotificationModel nm)
    {
        String sql ="DELETE FROM Notification WHERE travellerId="+nm.getTravellerID() ;
        executer.ExecuteQuery(sql);
    }
    ///////////////////////////SELECT ////////////////////////
    public ArrayList<NotificationModel> getTravellerNotification(int id) throws SQLException {// With no Acceptance
        String sql = "SELECT * FROM Notification where travellerId="+id;
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<NotificationModel> NotificationsSatisfied = new ArrayList<>();
            while (rs.next()) {
                //Display values
                NotificationModel N= new NotificationModel(rs.getInt("notificationId")
                        ,rs.getInt("travellerId"), rs.getInt("appointmentId"),
                        rs.getString("description"));
                NotificationsSatisfied.add(N);
            }
            return NotificationsSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }
}
