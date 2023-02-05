package net.tonimatasdev.perworldall.perworld.tablist;

import net.tonimatasdev.perworldall.PerWorldAll;
import net.tonimatasdev.perworldall.perworld.tablist.listener.PlayerChangeWorldListener;
import net.tonimatasdev.perworldall.perworld.tablist.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TabList {
    public static void register() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[PerWorldAll] PerWorldTabList loaded.");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerChangeWorldListener(), PerWorldAll.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), PerWorldAll.getInstance());
    }
}
