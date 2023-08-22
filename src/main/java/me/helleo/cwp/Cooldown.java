package me.helleo.cwp;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Cooldown {

    public static HashMap<UUID, Double> cooldowns = new HashMap<>();

    public static void setupCooldown() {
    }

    //setcooldown
    public static void setCooldown(Player player, int seconds) {
        double delay = System.currentTimeMillis() + (seconds * 1000L);
        cooldowns.put(player.getUniqueId(), delay);
    }

    //getcooldown
    public static int getCooldown(Player player) {
        return Math.toIntExact(Math.round((cooldowns.get(player.getUniqueId()) - (double) System.currentTimeMillis() / 1000)));
    }

    //checkcooldown
    public static boolean checkCooldown(Player player) {
        return !cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis();
    }

}
