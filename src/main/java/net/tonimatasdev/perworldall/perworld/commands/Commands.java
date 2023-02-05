package net.tonimatasdev.perworldall.perworld.commands;

import net.tonimatasdev.perworldall.PerWorldAll;
import net.tonimatasdev.perworldall.perworld.commands.listener.PlayerCommandPreprocessListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Commands {
    public static void register() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[PerWorldAll] PerWorldCommands loaded.");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessListener(), PerWorldAll.getInstance());
    }
}
