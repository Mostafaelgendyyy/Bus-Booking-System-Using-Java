package LogicCode.Admin;

import LogicCode.Traveller.observer;


public interface Notifier {

    public abstract void NotifiyTraveller(observer o, String News,int AppID,int TID);
}
