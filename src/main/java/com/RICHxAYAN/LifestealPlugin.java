package com.RICHxAYAN;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LifestealPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("LifestealPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LifestealPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("examplecommand")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("Hello, " + player.getName() + "! This is an example command.");
            } else {
                sender.sendMessage("This command can only be executed by a player.");
            }
            return true;
        }
        return false;
    }
}
