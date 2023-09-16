package Database;

import LogicCode.Traveller.TravellerController;
import LogicCode.Traveller.TravellerModel;

import java.sql.*;

import static Database.Connector.*;

public class TravellerTable {
    Connector executer = new Connector();

    public void createTable(){
        String sql = "CREATE TABLE Traveller " +
                "(travellerId INTEGER AUTO_INCREMENT, " +
                " name VARCHAR(50), " +
                " email VARCHAR(50) UNIQUE, " +
                " password varchar(50), " +
                " username VARCHAR(50) UNIQUE, " +
                " acceptanceAccount bit, " +
                " PRIMARY KEY ( travellerId ))";
        executer.ExecuteQuery(sql);
    }
    public void insert(TravellerModel TM)
    {
        String sql ="INSERT INTO traveller(name,email,password,username,acceptanceAccount) VALUES " +
                "('"+TM.getName()+"', '"+TM.getEmail() + "', '"+TM.getPassword()+"', '"+TM.getUsername()+"', "+TM.isActivated()+");";
        System.out.println(sql);
        executer.ExecuteQuery(sql);
    }

    public void update (String Username, boolean active){ // For admin Activation for Travellers
        String sql = "UPDATE Traveller " +
                "SET acceptanceAccount = " + active+ " WHERE username ='" + Username+"'";
        executer.ExecuteQuery(sql);
    }

    public void delete(TravellerModel TM)
    {
        String sql ="DELETE FROM Traveller  WHERE username ='"+TM.getUsername()+"'" ;
        executer.ExecuteQuery(sql);
    }


    public TravellerController CheckLogin(String US, String Pass) throws SQLException {
        String sql = "SELECT * FROM traveller t where t.username ='" +US+"' AND t.acceptanceAccount = 1;";
        TravellerModel TravellerSatisfied ;
        TravellerController c =new TravellerController();

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            boolean found = false;
            System.out.println("Database Select Query Executed Successfully successfully...");
            while(rs.next()) {
                //Display values
                if (Pass.equals(rs.getString("password"))){
                    TravellerSatisfied = new TravellerModel(rs.getInt("travellerId"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("username"),
                            rs.getBoolean("acceptanceAccount"));
                    found=true;
                    System.out.println(TravellerSatisfied.GetTravellerData());
                    c.setModel(TravellerSatisfied);
                    break;
                }
                else if (!found){
                    c.setModel(null);
                }
            }
            if (!found){
                c.setModel(null);
            }
            return c;
        } catch (SQLException e) {
            System.out.println("Error, Database Select Query isn't Executed");
            e.printStackTrace();
            return null;
        }
    }
}
