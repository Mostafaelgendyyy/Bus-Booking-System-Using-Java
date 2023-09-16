package Database;

import LogicCode.Admin.AdminController;
import LogicCode.Admin.AdminModel;
import LogicCode.Appointment.AppointmentModel;

import java.sql.*;

import static Database.Connector.*;

public class AdminTable {
    Connector executer = new Connector();

    public void createTable(){
        String sql = "CREATE TABLE Admin " +
                "(adminId INTEGER AUTO_INCREMENT," +
                " name VARCHAR(50)," +
                " email VARCHAR(50) UNIQUE," +
                " password varchar(50)," +
                " username VARCHAR(50) UNIQUE," +
                " PRIMARY KEY ( adminId ));";
        executer.ExecuteQuery(sql);
    }

    public void insert(AdminModel a)
    {
        String sql ="INSERT INTO Admin (name,email,password,username) VALUES ('"+a.getName()+"', '"+a.getEmail()
                +"', '"+a.getPassword()+"', '"+a.getUsername()+"')";
        executer.ExecuteQuery(sql);
    }

    public void delete(AdminModel a)
    {
        String sql ="DELETE FROM Admin " + "WHERE username ='"+a.getUsername()+"'" ;
        executer.ExecuteQuery(sql);
    }
    public AdminController CheckLogin(String US, String Pass) throws SQLException {

        String sql = "SELECT * FROM Admin a where a.username ='" +US+"';";
        AdminModel AdminSatisfied ;
        AdminController c =new AdminController();

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
                    AdminSatisfied = new AdminModel(rs.getInt("adminId"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("username"));
                    found=true;
                    System.out.println(AdminSatisfied.getAdminData());
                    c.setModel(AdminSatisfied);
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
