package net.tonimatasdev.perworldall.perworld.chat;

import net.tonimatasdev.perworldall.PerWorldAll;
import net.tonimatasdev.perworldall.perworld.chat.listener.AsyncPlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Chat {
    public static void register() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[PerWorldAll] PerWorldChat loaded.");
        Bukkit.getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), PerWorldAll.getInstance());
    }
}
