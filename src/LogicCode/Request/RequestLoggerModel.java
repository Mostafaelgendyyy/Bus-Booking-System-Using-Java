package LogicCode.Request;

import Database.SearchLogTable;

import java.sql.SQLException;

public class RequestLoggerModel {
    SearchLogTable SLT= new SearchLogTable();
    public void showHistory(int TravellerId) throws SQLException {
        SLT.getTravellerSearches(TravellerId);
    }
    public void insertSearch(int TID, int APID){
        SLT.insert(TID, APID);
    }
}
