package Database;

import java.sql.*;

import static Database.Connector.*;

public class SearchLogTable {
    Connector executer = new Connector();

    public void createTable(){
        String sql = "CREATE TABLE SearchLog " +
                "(searchId INTEGER AUTO_INCREMENT, " +
                " travellerId INTEGER, " +
                " appointmentId INTEGER, " +
                " PRIMARY KEY ( searchId )," +
                " FOREIGN KEY (travellerId) REFERENCES traveller(travellerId)," +
                " FOREIGN KEY (appointmentId) REFERENCES busappointment(appointmentId))";
        executer.ExecuteQuery(sql);
    }

    public void insert(int TID, int APID)
    {
        String sql ="INSERT INTO SearchLog (travellerId,appointmentId) VALUES ("+TID+", "+ APID+")";
        executer.ExecuteQuery(sql);
    }

    /////////////////////////////// selection ///////////////////////////////////////

    public void getTravellerSearches(int TID) throws SQLException {
        String sql = "SELECT * FROM SearchLog";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Display values
                System.out.println("Traveller Searches: ");
                System.out.print("Searcn ID: " + rs.getInt("searchId"));
                System.out.print(", Traveller ID: " + rs.getInt("travellerId"));
                System.out.print(", Appointment ID: " + rs.getInt("appointmentId"));
                System.out.println("");
            }
        }
        catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
        }
    }
}
