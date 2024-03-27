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

public class Pay_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        String target = args[0];
        Player t = Bukkit.getPlayer(target);
        int coinsToPay = Integer.parseInt(args[1]);

        if(args.length >= 1) {
            try {
                PlayerCoins pc = new PlayerCoins(CoinsApi.getInstance(), p.getUniqueId());
                if(pc.getCoins() >= coinsToPay) {


                    try {
                        PlayerCoins playerCoins = new PlayerCoins(CoinsApi.getInstance(), t.getUniqueId());
                        playerCoins.addCoins(coinsToPay);
                        t.sendMessage(CoinsApi.Coins + "§7Du hast §a" + coinsToPay + "§7 Coins von dem Spieler §a" + p.getDisplayName() + "§7 bekommen!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        PlayerCoins playerCoins = new PlayerCoins(CoinsApi.getInstance(), p.getUniqueId());
                        playerCoins.removeCoins(coinsToPay);
                        p.sendMessage(CoinsApi.Coins + "§7Du hast dem Spieler §a" + t.getDisplayName() + "§a " + coinsToPay + "§7 Coins gegeben!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else
                    p.sendMessage(CoinsApi.Coins + "§cDu hast nicht genügend Coins um dem Spieler §a" + t.getDisplayName() + "§a " + coinsToPay + "§7 Coins zu geben!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
            p.sendMessage(CoinsApi.Coins + "§cBitte benutze §a/pay <Spielername> <CoinsToPay>");



        return false;
    }
}
