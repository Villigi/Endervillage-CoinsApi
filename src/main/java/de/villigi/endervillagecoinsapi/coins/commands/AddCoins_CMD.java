package de.villigi.endervillagecoinsapi.coins.commands;

import de.villigi.endervillagecoinsapi.CoinsApi;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class AddCoins_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        String target = args[0];
        Player t = Bukkit.getPlayer(target);
        int targetCoins = Integer.parseInt(args[1]);

        if(t == null) {
            p.sendMessage(CoinsApi.Coins + "§cDer Spieler §a" + target + "§c Ist nicht Online oder exestiert nicht!");
        }

        if(args.length == 0) {
            p.sendMessage(CoinsApi.Coins + "§cZu wenig Argumente. §a/addcoins <Spierlanme> <Coins>");
        }

        if(p.hasPermission("AG.api.Coins.add")) {
            if(args.length == 2) {
                //addcoins <coins> <Player>
                try {
                    PlayerCoins playerCoins = new PlayerCoins(CoinsApi.getInstance(), t.getUniqueId());
                    playerCoins.addCoins(targetCoins);
                    p.sendMessage(CoinsApi.Coins + "§7Du hast dem Spieler §a" + targetCoins + "§7 gegeben!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else
                p.sendMessage(CoinsApi.Coins + "§cZu wenig Argumente. §a/addcoins <Spierlanme> <Coins>");

        }else
            p.sendMessage(CoinsApi.Coins + "§cDazu hast du keine Rechte!");




        return false;
    }
}
