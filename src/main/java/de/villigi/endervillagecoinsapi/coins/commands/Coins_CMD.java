package de.villigi.endervillagecoinsapi.coins.commands;

import de.villigi.endervillagecoinsapi.CoinsApi;
import de.villigi.endervillagecoinsapi.coins.database.PlayerCoins;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Coins_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
            try {
                PlayerCoins playerCoins = new PlayerCoins(CoinsApi.getInstance(), p.getUniqueId());
                p.sendMessage(CoinsApi.Coins + "§7Du hast aktuell §a" + playerCoins.getCoins() + "§7 Coins auf deinem Konto!");
                p.sendMessage(CoinsApi.Coins + "§cBenutze §a/Profile <Spielername> §7um die coins von anderen Spielern zu sehen ");

            } catch (SQLException e) {
                e.printStackTrace();
            }





        return false;
    }
}
