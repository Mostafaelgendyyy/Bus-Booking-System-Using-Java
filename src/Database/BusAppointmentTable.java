package Database;


import LogicCode.Appointment.AppointmentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import static Database.Connector.*;

public class BusAppointmentTable {
    Connector executer = new Connector();

    public void createTable(){
        String sql = "CREATE TABLE BusAppointment " +
                "(appointmentId INTEGER AUTO_INCREMENT, " +
                " maxTravellers INTEGER, " +
                " RequestsNumber INTEGER, "+
                " destination varchar(70), " +
                " appointmentDate varchar(30), "+
                " PRIMARY KEY ( appointmentId ))";
        executer.ExecuteQuery(sql);
    }


    public void insert(AppointmentModel a)
    {
        String sql ="INSERT INTO BusAppointment(maxTravellers,RequestsNumber,destination,appointmentDate) VALUES " +
                "("+a.getMaxTravellers()+", "+a.getRequests()+", '"+a.getDestination() +"', '"+a.getDate()+"')";
        System.out.println(sql);
        executer.ExecuteQuery(sql);
    }

    public void updateDate(int id, String d)
    {
        String sql = "UPDATE BusAppointment " +
                "SET appointmentDate = '" + d + "' WHERE appointmentId =" + id;
        executer.ExecuteQuery(sql);
    }

    public void updateDestination(int id, String dest)
    {
        String sql = "UPDATE BusAppointment " +
                "SET destination = '" + dest + "' WHERE appointmentId =" + id;
        executer.ExecuteQuery(sql);
    }

    public void updateNumTravellers(int id, int n)
    {
        String sql = "UPDATE BusAppointment " +
                "SET RequestsNumber = " + n + " WHERE appointmentId =" + id;
        executer.ExecuteQuery(sql);
    }

    public void delete(int id)
    {
        String sql ="DELETE FROM BusAppointment WHERE appointmentId="+id ;
        executer.ExecuteQuery(sql);
    }

    //////////////////////////////////// Selection /////////////////////////////////////////

    public ArrayList<AppointmentModel> getAppointmentsbyDestination(String Destination) throws SQLException {// With no Acceptance
        String sql = "SELECT * FROM BusAppointment where destination ='" +Destination+"'";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<AppointmentModel> AppointmentsSatisfied = new ArrayList<>();
            while (rs.next()) {
                //Display values
                AppointmentModel M = new AppointmentModel(rs.getInt("appointmentId"),
                        rs.getString("destination"),
                        rs.getString("appointmentDate"),
                        rs.getInt("maxTravellers"),
                        rs.getInt("RequestsNumber"));

                AppointmentsSatisfied.add(M);
            }
            return AppointmentsSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<AppointmentModel> getAppointmentsbyDate(String d) throws SQLException {// With no Acceptance
        String sql = "SELECT * FROM BusAppointment where appointmentDate ='" +d+"'";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<AppointmentModel> AppointmentsSatisfied = new ArrayList<>();
            while (rs.next()) {
                //Display values
                AppointmentModel M = new AppointmentModel(rs.getInt("appointmentId"),
                        rs.getString("destination"),
                        rs.getString("appointmentDate"),
                        rs.getInt("maxTravellers"),
                        rs.getInt("RequestsNumber"));

                AppointmentsSatisfied.add(M);
            }
            return AppointmentsSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<AppointmentModel> getUnCompletedAppointments() throws SQLException {// With no Acceptance
        String sql = "SELECT * FROM BusAppointment WHERE maxTravellers > RequestsNumber";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<AppointmentModel> AppointmentsSatisfied = new ArrayList<>();
            while (rs.next()) {
                //Display values
                AppointmentModel M = new AppointmentModel(rs.getInt("appointmentId"),
                        rs.getString("destination"),
                        rs.getString("appointmentDate"),
                        rs.getInt("maxTravellers"),
                        rs.getInt("RequestsNumber"));

                AppointmentsSatisfied.add(M);
            }
            return AppointmentsSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<AppointmentModel> getAllAppointments() throws SQLException {// With no Acceptance
        String sql = "SELECT * FROM BusAppointment";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<AppointmentModel> AppointmentsSatisfied = new ArrayList<>();
            while (rs.next()) {
                //Display values
                AppointmentModel M = new AppointmentModel(rs.getInt("appointmentId"),
                        rs.getString("destination"),
                        rs.getString("appointmentDate"),
                        rs.getInt("maxTravellers"),
                        rs.getInt("RequestsNumber"));

                AppointmentsSatisfied.add(M);
            }
            return AppointmentsSatisfied;
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }

}
