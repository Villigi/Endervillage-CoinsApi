package de.villigi.endervillagecoinsapi.coins.listener;

import de.villigi.endervillagecoinsapi.CoinsApi;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoins;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoinsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class CoinsConnectionListener implements Listener {

    private CoinsApi main;

    public CoinsConnectionListener(CoinsApi main) {
        this.main = main;
    }


    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        Player p = (Player) event.getPlayer();

        try {
            PlayerCoins playerData = new PlayerCoins(CoinsApi.getInstance(), p.getUniqueId());
            PlayerCoinsManager playerCoinsManager = new PlayerCoinsManager();
            playerCoinsManager.addCustomPlayer(p.getUniqueId(), playerData);
        } catch (SQLException e) {
            e.printStackTrace();
            p.kickPlayer(CoinsApi.Coins + "§cEs ist ein Fehler mit der Datenbank verbindung (CustomPlayer) passiert. Melde einem teamitglied den Fehler code: §4#43625");

        }


    }


}
