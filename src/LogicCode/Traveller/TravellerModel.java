package LogicCode.Traveller;

import LogicCode.PersonAbstraction.PersonModel;

public class TravellerModel extends PersonModel {

    private int Travellerid;
    private boolean Activated;
    private TravellerManagerModel Manager=new TravellerManagerModel();

    public TravellerModel() {
        super();
    }

    public TravellerModel(int travellerid, String n, String mail, String Pass, String username, boolean activated) {
        super(travellerid, n, mail,Pass,username);
        this.Travellerid = travellerid;
        this.Activated = activated;

    }
    public TravellerModel(String n, String mail,String Pass,String username, boolean activated) {
        super( n, mail,Pass,username);
        this.Activated = activated;

    }

    public String GetTravellerData() {

        String Str= super.GetPersonData();
        return "TravellerModel{" +
                " Travellerid=" + Travellerid +
                Str +
                '}';
    }


    public int getTravellerid() {
        return Travellerid;
    }

    public void setTravellerid(int travellerid) {
        Travellerid = travellerid;
    }

    public boolean isActivated() {
        return Activated;
    }

    public void setActivated(boolean activated) {
        Activated = activated;
    }

    public TravellerManagerModel getManager() {
        return Manager;
    }

    public void setManager(TravellerManagerModel manager) {
        Manager = manager;
    }
}
