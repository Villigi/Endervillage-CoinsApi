package de.villigi.endervillagecoinsapi.coins;

import de.villigi.endervillagecoinsapi.CoinsApi;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoins;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoinsManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StarterCoinsListener implements Listener {

    @EventHandler
    public void onStarterConnect(PlayerJoinEvent event) {
        Player p = (Player) event.getPlayer();

        if(!p.hasPlayedBefore()) {

            p.sendMessage(API.CoinSystem + ChatColor.translateAlternateColorCodes('&', AGpi.apicfg.getString("Coins.Firstjoin")));
        }


    }


}
