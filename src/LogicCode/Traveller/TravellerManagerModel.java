package LogicCode.Traveller;

import Database.TravellerTable;

import java.sql.SQLException;

public class TravellerManagerModel {
    TravellerTable table=new TravellerTable();
    public void AddTraveller(TravellerModel t){
        table.insert(t);
    }

    public void UpdateTraveller(String Username ,boolean active){
        table.update(Username,active);
    }

    public void DeleteTraveller(TravellerModel t){
        table.delete(t);
    }

    public TravellerController CheckLogin(String US, String Pass) throws SQLException {
        TravellerController TravellerSatisfied = table.CheckLogin(US,Pass);
        return TravellerSatisfied;
    }

}
