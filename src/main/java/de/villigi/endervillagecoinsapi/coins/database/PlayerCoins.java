package de.villigi.endervillagecoinsapi.coins.database;

import de.villigi.endervillagecoinsapi.CoinsApi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerCoins {


    //Todo UUID   |   Coins

    private UUID uuid;
    private CoinsApi main;

    private int coins;



    public PlayerCoins(CoinsApi main, UUID uuid) throws SQLException {

        this.main = main;
        this.uuid = uuid;

        ResultSet resultSet = null;

        PreparedStatement statement = main.getDatabaseManager().getConnection().prepareStatement("SELECT Coins FROM Coins WHERE UUID = ?;");
        statement.setString(1, uuid.toString());
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            coins = resultSet.getInt("Coins");
        }else {
            coins = 0;
            PreparedStatement statement1 = main.getDatabaseManager().getConnection().prepareStatement("INSERT INTO Coins (UUID, Coins) VALUES (" +
                    "'" + uuid + "'," +
                    "" + coins + ");");

            statement1.executeUpdate();
        }
    }


    public void setCoins(int coins) {
        this.coins = coins;
        try {
            PreparedStatement statement = CoinsApi.getInstance().getDatabaseManager().getConnection().prepareStatement("UPDATE Coins SET Coins = '" + coins + "' WHERE UUID = '" + uuid + "';");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCoins(int coins) {
        setCoins(getCoins() +coins);
    }

    public void removeCoins(int coins) {
        setCoins(getCoins() -coins);
    }

    public int getCoins() {
        return coins;
    }
}
