import database.DBManager;
import  database.Service;

public class Main {

    public static void main(String args[]) {

        DBManager dbManager = new DBManager("jdbc:mysql://localhost:3306/information_about_vanished", "root", "xyf377j0");

        Service s = new Service(dbManager);
        s.createRegion();
        s.createVanished();
        s.createLastPlace();
        
       // s.dropTables();

        dbManager.close();

    }
}
