package LogicCode.Admin;

import LogicCode.Request.RequestController;
import LogicCode.Request.RequestModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminRequestsOption {

    private RequestController RC = new RequestController();

    public ArrayList<RequestModel> seeRequest() throws SQLException {
        return this.RC.getModel().getRUC().seeRequest();
    }

    public void showhistory(int id) throws SQLException {
        this.RC.getModel().getLogger().showHistory(id);
    }

    public RequestController getRC() {
        return RC;
    }

    public void setRC(RequestController RC) {
        this.RC = RC;
    }
}
