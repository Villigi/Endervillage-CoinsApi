package de.villigi.endervillagecoinsapi.coins.database;

import java.util.HashMap;
import java.util.UUID;

public class PlayerCoinsManager {

    private HashMap<UUID, PlayerCoins> customPlayer = new HashMap<>();


    public PlayerCoins getCustomPlayer(UUID uuid) {
        return customPlayer.get(uuid);

    }

    public void addCustomPlayer(UUID uuid, PlayerCoins player) {
        customPlayer.put(uuid, player);
    }

    public void removeCustomPlayer(UUID uuid) {
        customPlayer.remove(uuid);
    }


}
