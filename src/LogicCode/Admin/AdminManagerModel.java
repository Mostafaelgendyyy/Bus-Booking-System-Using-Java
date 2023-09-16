package LogicCode.Admin;

import Database.AdminTable;

import java.sql.SQLException;

public class AdminManagerModel {
    AdminTable AT= new AdminTable();
    public void AddAdmin(AdminModel a){
        AT.insert(a);
    }

    public void DeleteAdmin(AdminModel a){
        AT.delete(a);
    }

    public AdminController CheckLogin(String US,String Pass) throws SQLException {
        AdminController AdminSatisfied = AT.CheckLogin(US,Pass);
        return AdminSatisfied;
    }

}
