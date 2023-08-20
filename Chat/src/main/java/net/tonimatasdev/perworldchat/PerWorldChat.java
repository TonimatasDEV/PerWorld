package net.tonimatasdev.perworldchat;

import net.tonimatasdev.perworldchat.listener.AsyncPlayerChatListener;
import net.tonimatasdev.perworldcore.api.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class PerWorldChat extends JavaPlugin {
    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        Messages.sendEnabledOrDisable(this, true);
        Bukkit.getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

    @Override
    public void onDisable() {
        Messages.sendEnabledOrDisable(this, false);
    }

    public static Plugin getInstance() {
        return instance;
    }
}
