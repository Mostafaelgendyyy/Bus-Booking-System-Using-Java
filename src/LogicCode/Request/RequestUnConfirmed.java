package LogicCode.Request;

import Database.RequestTable;

import java.sql.SQLException;
import java.util.ArrayList;

public class RequestUnConfirmed {
    RequestTable RT= new RequestTable();
    public ArrayList<RequestModel> seeRequest() throws SQLException {
        return RT.getRequestsNoAcceptance();
    }
}
