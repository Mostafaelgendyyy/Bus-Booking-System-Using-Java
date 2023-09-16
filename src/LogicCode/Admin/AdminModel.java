package LogicCode.Admin;

import LogicCode.PersonAbstraction.PersonModel;

public class AdminModel extends PersonModel {
    private AdminActivatorModel Activator= new AdminActivatorModel();
    private AdminManagerModel AMM= new AdminManagerModel();

    public AdminModel() {
        super();
    }
    public AdminModel(int id, String n, String mail, String Pass,String username) {
        super(id, n, mail, Pass,username);
    }
    public AdminModel( String n, String mail, String Pass,String username) {
        super( n, mail, Pass,username);
    }

    public AdminActivatorModel getActivator() {
        return Activator;
    }

    public void setActivator(AdminActivatorModel activator) {
        Activator = activator;
    }

    public AdminManagerModel getAMM() {
        return AMM;
    }

    public void setAMM(AdminManagerModel AMM) {
        this.AMM = AMM;
    }


    public String getAdminData() {
        String Str= super.GetPersonData();
        return "AdminModel{" +
                Str+
                '}';
    }
}
