package Database;
import LogicCode.Traveller.TravellerModel;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class Connector {
    static final String DB_URL = "jdbc:mysql://localhost/eaaa";
    static final String USER = "root";
    static final String PASS = "";

    public void ExecuteQuery(String sql) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(sql);
            System.out.println("Database Query Executed Successfully successfully...");
        } catch (SQLException e) {
            System.out.println("Error, Database Query isn't Executed");
            e.printStackTrace();
        }
    }

}
