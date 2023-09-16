package LogicCode.Traveller;

import LogicCode.Request.RequestController;
import LogicCode.Request.RequestModel;

public class TravellerRequestOptions {
    private RequestController RC=new RequestController();
    public void saveRequest(RequestModel r)
    {
        this.RC.getModel().getManager().saveRequest(r);
    }
    public void UpdateRequest(RequestModel r)
    {
        this.RC.getModel().getManager().UpdateRequest(r);
    }
    public void DeleteRequest(RequestModel r)
    {
        this.RC.getModel().getManager().DeleteRequest(r);
    }
    
    public RequestController getRC() {
        return RC;
    }

    public void setRC(RequestController RC) {
        this.RC = RC;
    }
}
