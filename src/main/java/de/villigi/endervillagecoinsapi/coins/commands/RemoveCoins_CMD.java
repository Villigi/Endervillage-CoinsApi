package de.villigi.endervillagecoinsapi.coins.commands;

import de.villigi.endervillagecoinsapi.CoinsApi;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoins;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class RemoveCoins_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        String target = args[1];
        Player t = Bukkit.getPlayer(target);
        int coinstoremove = Integer.parseInt(args[0]);

        if(p.hasPermission("AG.api.Coins.remove")) {
            if(p == t) {
                try {
                    PlayerCoins playerCoins = new PlayerCoins(CoinsApi.getInstance(), p.getUniqueId());
                    playerCoins.removeCoins(coinstoremove);
                    p.sendMessage(CoinsApi.Coins + "§7Du hast dem Spieler §a" + t.getDisplayName() + "§a " + coinstoremove + "§7 Coins von seinem Konto abgezogen!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(args.length >= 1) {

                try {
                    PlayerCoins playerCoins = new PlayerCoins(CoinsApi.getInstance(), t.getUniqueId());
                    playerCoins.removeCoins(coinstoremove);
                    p.sendMessage(CoinsApi.Coins + "§7Du hast dem Spieler §a" + t.getDisplayName() + "§a " + coinstoremove + "§7 Coins von seinem Konto abgezogen!");
                    t.sendMessage(CoinsApi.Coins + "§7Dir wurden von dem Spieler §a" + p.getDisplayName() + "§a " + coinstoremove + "§7 Coins von deinem Konto abgezogen");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else
            p.sendMessage(CoinsApi.Coins + "§cKeine Rechte!");

        return false;
    }
}
