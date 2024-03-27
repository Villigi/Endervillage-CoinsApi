package de.villigi.endervillagecoinsapi.coins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private final String HOST = "localhost";
    private final int PORT = 3306;
    private final String DATABASE = "AGManager";
    private final String USERNAME = "root";
    private final String PASSWORD = "41NqRN0F";

    private Connection connection;

    public void connect() throws SQLException {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                    USERNAME,
                    PASSWORD);


    }


    public boolean isConnectet() {
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }


    public void disconnect() {

        if(isConnectet()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }




}
