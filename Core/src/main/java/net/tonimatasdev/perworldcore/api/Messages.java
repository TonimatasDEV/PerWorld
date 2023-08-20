package net.tonimatasdev.perworldcore.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Messages {
    public static void sendEnabledOrDisable(Plugin plugin, boolean enable) {
        if (enable) {
            sendConsoleMessage("[PerWorldCore] " + ChatColor.GREEN + plugin.getName() + " has been enabled.");
        } else {
            sendConsoleMessage("[PerWorldCore] " + ChatColor.RED + plugin.getName() + " has been disabled.");
        }
    }

    public static void sendConsoleMessage(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(message);
    }
}
