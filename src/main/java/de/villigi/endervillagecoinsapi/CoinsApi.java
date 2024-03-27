package de.villigi.endervillagecoinsapi;

import de.villigi.endervillagecoinsapi.coins.API;
import de.villigi.endervillagecoinsapi.coins.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.sql.SQLException;

public final class CoinsApi extends JavaPlugin {

    private static CoinsApi instance;
    private DatabaseManager databaseManager;
    private API api;

    public static final String Coins = "§b§lEndervillage §7» ";

    @Override
    public void onEnable() {
        instance = this;
        databaseManager = new DatabaseManager();
        api = new API();
        try {
            databaseManager.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public API getApi() {
        return api;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public static CoinsApi getInstance() {
        return instance;
    }
}
