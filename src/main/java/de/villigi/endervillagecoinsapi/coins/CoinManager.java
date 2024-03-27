package de.villigi.endervillagecoinsapi.coins;

import de.villigi.endervillagecoinsapi.CoinsApi;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CoinManager {


    public int getCoins(Player player) {
        File file = new File("plugins//AGPIv2//Coins//PlayerCoiny.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.getInt("player." + player.getUniqueId() + ".coins");
    }


    public void setCoins(Player player, int coins) {
        File file = new File("plugins//AGPIv2//Coins//PlayerCoiny.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set("player." + player.getUniqueId() + "coins", coins);

        try {
            config.save(file);
        }catch (Exception e) {
            e.printStackTrace();
            player.sendMessage(CoinsApi.Coins + "§cEs ist ein Fehler mit dem Coins Speicherort passiert bitte melde dich bei einem Teammitglied!");
        }
    }


    public void addCoins(Player player, int coins) {
        File file = new File("plugins//AGPIv2//Coins//PlayerCoiny.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set("player." + player.getUniqueId() + "coins", config.getInt("player." + player.getUniqueId() + ".coins") + coins);

        try {

        }catch (Exception e) {
            e.printStackTrace();
            player.sendMessage(CoinsApi.Coins + "§cEs ist ein Fehler aufgetreten melde bitte einem Teammitglied den Fehler §4#15326");
        }
    }

    public void removeCoins(Player player, int coins) {
        File file = new File("plugins//AGPIv2//Coins//PlayerCoiny.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set("player." + player.getUniqueId() + "coins", config.getInt("player." + player.getUniqueId() + ".coins") - coins);

        try {

        }catch (Exception e) {
            e.printStackTrace();
            player.sendMessage(CoinsApi.Coins + "§cEs ist ein Fehler aufgetreten melde bitte einem Teammitglied den Fehler §4#68745");
        }
    }



}
