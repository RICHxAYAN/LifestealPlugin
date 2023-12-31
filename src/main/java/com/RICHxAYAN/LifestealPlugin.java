package com.RICHxAYAN.lifestealplugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LifestealPlugin extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        // Register events and load configuration
        getServer().getPluginManager().registerEvents(this, this);
        config = getConfig();
        saveDefaultConfig();
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            String worldName = player.getWorld().getName();

            if (config.contains("worlds." + worldName)) {
                double lifestealMultiplier = config.getDouble("worlds." + worldName + ".lifesteal-multiplier");
                double lifestealAmount = calculateLifesteal(event.getDamage(), lifestealMultiplier);

                // Adjust player health
                player.setHealth(player.getHealth() + lifestealAmount);
            }
        }
    }

    private double calculateLifesteal(double damage, double multiplier) {
        // Implement your lifesteal calculation logic
        // Example: return 2.0 for lifesteal of 2 hearts
        return damage * multiplier;
    }
}
