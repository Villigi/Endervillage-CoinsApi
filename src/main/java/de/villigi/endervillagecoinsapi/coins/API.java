package de.villigi.endervillagecoinsapi.coins;

import de.villigi.endervillagecoinsapi.CoinsApi;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoins;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class API {

    public static void addCoins(Player player, int coins) {
        PlayerCoins playerCoins = null;
        try {
            playerCoins = new PlayerCoins(CoinsApi.getInstance(), player.getUniqueId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        playerCoins.addCoins(coins);
    }
    public static void setCoins(Player player, int coins) {
        PlayerCoins playerCoins = null;
        try {
            playerCoins = new PlayerCoins(CoinsApi.getInstance(), player.getUniqueId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        playerCoins.setCoins(coins);
    }
    public static void removeCoins(Player player, int coins) {
        PlayerCoins playerCoins = null;
        try {
            playerCoins = new PlayerCoins(CoinsApi.getInstance(), player.getUniqueId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        playerCoins.removeCoins(coins);
    }

    public static int getCoins(Player player) {
        PlayerCoins playerCoins = null;
        try {
            playerCoins = new PlayerCoins(CoinsApi.getInstance(), player.getUniqueId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerCoins.getCoins();
    }


}
