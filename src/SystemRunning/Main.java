package SystemRunning;

import Database.*;
import LogicCode.Admin.AdminController;
import LogicCode.Admin.AdminModel;
import LogicCode.Appointment.AppointmentModel;
import LogicCode.Notifications.NotificationModel;
import LogicCode.Request.RequestModel;
import LogicCode.Traveller.TravellerController;
import LogicCode.Traveller.TravellerModel;

import javax.management.remote.NotificationResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private AdminController AC=new AdminController();
    private TravellerController TC=new TravellerController();
    Scanner input = new Scanner(System.in);

    public void getTravellerUI() throws SQLException
    {
        while (true)
        {
            System.out.println("1-Make Request");
            System.out.println("2-Search Appointment with Date");
            System.out.println("3-Search Appointment Destination");
            System.out.println("4-See Notifications");
            System.out.println("5-Logout");

            int choice =input.nextInt();
            if (choice==1)
            {
                ArrayList<AppointmentModel> Appointments =TC.getTAO().getUnCompletedAppointments();
                for (int i =0 ; i < Appointments.size();++i)
                {
                    System.out.println("Appointment ID"+ (i));
                    System.out.println(Appointments.get(i).getAppointmentData());
                    System.out.println("");
                }
                System.out.println("Do you Want to Make Request on any Appointment?");
                System.out.println("1-Yes");
                System.out.println("2-No");
                int RChoice = input.nextInt();
                if (RChoice==1)
                {
                    System.out.print("Enter Appointment ID: ");
                    int AID=input.nextInt();
                    RequestModel r= new RequestModel(false, TC.getModel().getId(),AID,false);
                    TC.getTRO().getRC().getModel().getManager().saveRequest(r);
                }

            }
            else if (choice==2)
            {
                System.out.print("Date : ");
                String Date = input.next();

                ArrayList<AppointmentModel>Appointments
                        =TC.getTAO().getAC().getModel().getSearcher().searchAppointmentsbyDate(Date);
                for(int i=0;i<Appointments.size();++i)
                {
                    System.out.println(Appointments.get(i).getAppointmentData());
                    TC.getTRO().getRC().getModel().getLogger().insertSearch(TC.getModel().getId(),Appointments.get(i).getAppointmentId());
                }

            }
            else if (choice==3)
            {
                System.out.print("Enter Destination Place: ");
                String Destination = input.next();
                ArrayList<AppointmentModel>Appointments
                        =TC.getTAO().getAC().getModel().getSearcher().searchAppointmentsbyDestination(Destination);
                for(int i=0;i<Appointments.size();++i)
                {
                    System.out.println(Appointments.get(i).getAppointmentData());
                    TC.getTRO().getRC().getModel().getLogger().insertSearch(TC.getModel().getId(),Appointments.get(i).getAppointmentId());
                }
            }
            else if (choice==4)
            {
                ArrayList<NotificationModel>Notifications =TC.getNC().getModel().getNT().
                        getTravellerNotification(TC.getModel().getTravellerid());
                for (int i =0; i<Notifications.size();++i)
                {
                    System.out.println(Notifications.get(i).GetNotificationData());
                }
            }
            else if (choice==5)
            {
                break;
            }

        }
    }

    public void getAdminUI() throws SQLException {
        while (true)
        {
            System.out.println("1-Suspend Traveller");
            System.out.println("2-Activate Traveller");
            System.out.println("3-Create Appointment");
            System.out.println("4-Change Appointment Date");
            System.out.println("5-Change Appointment Destination");
            System.out.println("6-Delete Appointment");
            System.out.println("7-See Requests with no Acceptance");
            System.out.println("8- Logout");

            int choice =input.nextInt();
            if (choice==1)
            {
                System.out.println("Enter Username: ");
                String us= input.next();
                AC.getModel().getActivator().updateTravellerActivation(us,false);
            }
            else if (choice==2)
            {
                System.out.println("Enter Username: ");
                String us= input.next();
                AC.getModel().getActivator().updateTravellerActivation(us,true);
            }
            else if (choice==3)
            {
                System.out.print("Enter Appointment Destination: ");
                String Dest= input.next();
                System.out.print("Enter Appointment Maximum Travellers: ");
                int Max= input.nextInt();
                System.out.print("Enter Appointment Date: ");
                String Date = input.next();
                AppointmentModel a= new AppointmentModel(Dest,Date,Max,0);
                this.AC.getAAO().createAppointment(a);
            }
            else if (choice==4)
            {
                System.out.print("Enter Appointment ID: ");
                int id= input.nextInt();
                System.out.print("Date Needed to be:");
                String Date = input.next();
                AC.UpdateAppointmentDate(id,Date);
            }
            else if (choice==5)
            {
                System.out.print("Enter Appointment ID: ");
                int id= input.nextInt();
                System.out.print("Destination Needed to be: ");
                String Dest= input.next();
                AC.UpdateAppointmentDestination(id,Dest);
            }
            else if (choice==6)
            {
                System.out.print("Enter Appointment ID: ");
                int id= input.nextInt();
                this.AC.getAAO().DeleteAppointment(id);

            }
            else if (choice ==7)
            {
                System.out.println("This Requests have no Acceptance");
                ArrayList<RequestModel> List= AC.getARO().seeRequest();
                for (int i = 0; i<List.size();++i)
                {
                    System.out.println(List.get(i).getRequestData());
                    System.out.println("Do you Accepted this Request?");
                    System.out.println("1-Yes");
                    System.out.println("2-No");
                    int UpdationChoice=input.nextInt();
                    if (UpdationChoice==1){
                        List.get(i).setAcceptance(true);
                        List.get(i).setAdminID(AC.getModel().getId());
                        AC.getARO().getRC().getModel().getManager().UpdateRequest(List.get(i));
//                        ArrayList<TravellerModel>M=AC.getARO().getRC().getModel().getManager().TravellersNotified(List.get(i).getId());
//                        for(int j =0; j<M.size();++i)
//                        {
//                            TravellerController Tc= new TravellerController();
//                            Tc.setModel(M.get(j));
//                            //AC.NotifiyTraveller(Tc,M.get(i).getId());
//                        }
                    }
                    else if (UpdationChoice==2){
                        List.get(i).setAcceptance(false);
                        List.get(i).setAdminID(AC.getModel().getId());
                        AC.getARO().getRC().getModel().getManager().UpdateRequest(List.get(i));
                    }

                }
            }
            else if (choice==8)
            {
                break;
            }
            else {
                System.out.println("Wrong Input Choice ...");
            }
        }
    }

    public void SIGNUP()
    {
        System.out.println("Welcome, SignUp as Traveller");


        System.out.print("Enter Name: ");
        String name= input.next();
        System.out.print("Enter Username: ");
        String username= input.next();
        System.out.print("Enter Email: ");
        String email= input.next();
        System.out.print("Enter Password: ");
        String password= input.next();
        while (true) {
            System.out.print("Enter Confirm Password: ");
            String ConPassword= input.next();
            if (password.equals(ConPassword))
                break;
            System.out.println("the Two Passwords are not the same");
        }
        TravellerModel m = new TravellerModel(name,email,password,username,true);
        TC.setModel(m);
        m.getManager().AddTraveller(m);
    }

    public void Login() throws SQLException {
        System.out.println("1-Login as Traveller");
        System.out.println("2-Login as Admin");

        int LoginChoice= input.nextInt();

        System.out.print("Enter UserName: ");
        String Username= input.next();
        System.out.println("Enter Password: ");
        String Password = input.next();
        TC=new TravellerController();
        AC=new AdminController();
        if (LoginChoice==1)
        {
            TC = TC.getModel().getManager().CheckLogin(Username,Password);
            if (TC.getModel()==null)
            {
                System.out.println("Wrong Data, Login Failed");
            }
            else{
                getTravellerUI();
            }
        }

        else if (LoginChoice==2)
        {
            AC = AC.getModel().getAMM().CheckLogin(Username,Password);
            if (AC.getModel()==null)
            {
                System.out.println("Wrong Data, Login Failed");
            }
            else{
                getAdminUI();
            }
        }
        else {
            System.out.println("Wrong Input Choice");
        }
    }

    public void Run() throws SQLException {
        while(true){
            System.out.println("1-Login");
            System.out.println("2-SignUp");
            System.out.println("3-Exit");
            int choice = input.nextInt();
            if (choice==1)// AS TRAVELLER OR ADMIN
            {
                Login();
            }
            else if (choice==2) // AS TRAVELLER ONLY
            {
                SIGNUP();
            }
            else if (choice==3)
            {
                return;
            }
        }

    }
    public static void main(String[]args) throws SQLException {
        Main System= new Main();
        System.Run();
//        Connector c = new Connector();
//        c.ExecuteQuery("CREATE DATABASE eaaa");
//
//        TravellerTable t= new TravellerTable();
//        t.createTable();
//
//        AdminTable a= new AdminTable();
//        a.createTable();
//
//        BusAppointmentTable b = new BusAppointmentTable();
//        b.createTable();
//
//        Notifications n= new Notifications();
//        n.createTable();
//
//        RequestTable r= new RequestTable();
//        r.createTable();
//
//        SearchLogTable s= new SearchLogTable();
//        s.createTable();
//        AdminModel aa= new AdminModel("Mostafa","ADMINNN","123","Admin1");
//        a.insert(aa);









    }
}
