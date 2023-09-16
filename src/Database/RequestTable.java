package Database;

import LogicCode.Notifications.NotificationModel;
import LogicCode.Request.RequestModel;
import LogicCode.Traveller.TravellerModel;

import java.sql.*;
import java.util.ArrayList;

import static Database.Connector.*;

public class RequestTable {
    Connector executer = new Connector();
    static final String DB_URL = "jdbc:mysql://localhost/busbooking";
    static final String USER = "root";
    static final String PASS = "";

    public void createTable(){
        String sql = "CREATE TABLE Request " +
                "(requestId INTEGER AUTO_INCREMENT, " +
                " travellerId INTEGER, " +
                " adminId INTEGER, " +
                " appointmentId INTEGER, " +
                " paid bit, " +
                " acceptance bit, " +
                " PRIMARY KEY ( requestId )," +
                " FOREIGN KEY (adminId) REFERENCES Admin(adminId)," +
                " FOREIGN KEY (travellerId) REFERENCES Traveller(travellerId)," +
                " FOREIGN KEY (appointmentId) REFERENCES BusAppointment(appointmentId))";
        executer.ExecuteQuery(sql);
    }

    public void insert(RequestModel rm)
    {
        String sql ="INSERT INTO Request(travellerId,adminId,appointmentId,paid,acceptance) VALUES " +
                "("+rm.getTravellerId()+", "+rm.getAdminID() +", "+rm.getAppointmentID()+", "+rm.isPaid()+", null)";
        executer.ExecuteQuery(sql);

    }

    public void update (RequestModel rm)
    {
        String sql = "UPDATE Request " +
                "SET acceptance = " + rm.isAcceptance() + " WHERE requestId =" + rm.getId();
        executer.ExecuteQuery(sql);
    }

    public void delete(RequestModel rm)
    {
        String sql ="DELETE FROM Request WHERE requestId="+rm.getId() ;
        executer.ExecuteQuery(sql);
    }
//////////////////////////////////// Selection /////////////////////////////////////////

    public ArrayList<RequestModel> getRequestsNoAcceptance() throws SQLException {// With no Acceptance
        String sql = "SELECT * FROM Request where acceptance is null";
        System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<RequestModel> RequestsSatisfied = new ArrayList<>();
            while(rs.next()) {
                //Display values
                RequestModel M = new RequestModel(rs.getInt("requestId"),
                        rs.getBoolean("paid"),rs.getInt("travellerID")
                        , rs.getInt("adminId"),rs.getInt("appointmentId")
                        ,rs.getBoolean("acceptance"));
                System.out.println(M.getAppointmentID());
                RequestsSatisfied.add(M);
            }
            return RequestsSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<Integer> TravellersNotified (int RID)throws SQLException {// With no Acceptance

        String sql = "SELECT travellerId FROM Request AS R where R.acceptance = 1 AND R.requestId = " + RID;
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Integer> TravellersSatisfied = new ArrayList<>();
            while (rs.next()) {
                //Display values
                int M = rs.getInt("travellerId");
                TravellersSatisfied.add(M);
            }
            return TravellersSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }
}

