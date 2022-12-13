package database;

public class Service {

    private DBManager dbManager;

    public Service(DBManager dbManager){
        this.dbManager = dbManager;
    }

    public void createRegion() {

        dbManager.executeUpdate("CREATE TABLE region " +
                "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "square FLOAT NOT NULL, " +
                "people_number INT NOT NULL, " +
                "animal_number INT NOT NULL)"
        );

    }

    public void createVanished() {

        dbManager.executeUpdate("CREATE TABLE vanished" +
                "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "type TEXT NOT NULL, " +
                "sex TEXT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "birth_date DATE NOT NULL, " +
                "miss_date DATE NOT NULL, " +
                "phone_number TEXT NOT NULL, " +
                "region INT NOT NULL, " +
                "FOREIGN KEY (region) REFERENCES region (id))"
        );

    }

    public void createLastPlace() {
        dbManager.executeUpdate("CREATE TABLE last_seeing_place " +
                "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "region_name TEXT NOT NULL, " +
                "street_name TEXT NOT NULL, " +
                "house_number TEXT NOT NULL, " +
                "vanished INT NOT NULL, " +
                "FOREIGN KEY (vanished) REFERENCES vanished (id))"
        );

    }

    public void dropTables(){

        dbManager.executeUpdate("DROP TABLE last_seeing_place;");
        dbManager.executeUpdate("DROP TABLE vanished;");
        dbManager.executeUpdate("DROP TABLE region;");

    }


}
