package LogicCode.Request;

public class RequestController {
    private RequestModel Model= new RequestModel();
    public String getRequestData(){
        return this.Model.getRequestData();
    }

    public RequestModel getModel() {
        return Model;
    }

    public void setModel(RequestModel model) {
        Model = model;
    }
}
