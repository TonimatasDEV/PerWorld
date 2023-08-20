package net.tonimatasdev.tablist;

import net.tonimatasdev.perworldcore.api.Messages;
import net.tonimatasdev.tablist.listener.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class PerWorldTabList extends JavaPlugin {
    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        Messages.sendEnabledOrDisable(this, true);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
    }

    @Override
    public void onDisable() {
        saveConfig();

        Messages.sendEnabledOrDisable(this, false);
    }

    public static Plugin getInstance() {
        return instance;
    }
}
