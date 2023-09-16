package LogicCode.Request;

import Database.RequestTable;
import LogicCode.Traveller.TravellerModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestManagerModel {
    RequestTable RT= new RequestTable();
    public void saveRequest(RequestModel r)
    {
        RT.insert(r);
    }
    public void UpdateRequest(RequestModel r)
    {
        RT.update(r);
    }
    public void DeleteRequest(RequestModel r)
    {
        RT.delete(r);
    }

    public ArrayList<Integer> TravellersNotified (int RID)throws SQLException {// With no Acceptance
        return RT.TravellersNotified(RID);
    }
}
