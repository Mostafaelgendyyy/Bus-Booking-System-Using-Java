package LogicCode.Admin;

import LogicCode.Traveller.TravellerManagerModel;
import LogicCode.Traveller.TravellerModel;

public class AdminActivatorModel {
    TravellerManagerModel TMM= new TravellerManagerModel();
    public void updateTravellerActivation(String Username,boolean active)
    {
        TMM.UpdateTraveller(Username,active);
    }

}
